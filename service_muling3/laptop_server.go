package service_muling3

import (
	"context"
	"errors"
	"log"
	"time"

	"github.com.muling3/pb"
	"github.com/google/uuid"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

type LaptopServer struct {
	pb.UnimplementedLaptopServiceServer
	Store LaptopStore
}

func NewLaptopServer(store LaptopStore) *LaptopServer {
	return &LaptopServer{Store: store}
}

func (s *LaptopServer) CreateLaptop(ctx context.Context, request *pb.CreateLaptopRequest) (*pb.CreateLaptopResponse, error) {
	laptop := request.GetLaptop()
	log.Printf("Received a new laptop with id: [%s]", laptop.Id)

	if len(laptop.Id) > 0 {
		_, err := uuid.Parse(laptop.Id)
		if err != nil {
			return nil, status.Errorf(codes.InvalidArgument, "laptop ID is not valid: %s", err)
		}
	} else {
		id, err := uuid.NewRandom()
		if err != nil {
			return nil, status.Errorf(codes.Internal, "Error occurred generating laptop id: %s", err)
		}

		laptop.Id = id.String()

	}

	time.Sleep(time.Second * 6)  //: for testing request timeout

	// check incase a client cancelled the request
	if ctx.Err() == context.Canceled {
		log.Print("client cancelled the request")
		return nil, status.Errorf(codes.Canceled, "request cancelled")
	}

	// check if the error is a timeout error
	if ctx.Err() == context.DeadlineExceeded {
		log.Print("request timed out")
		return nil, status.Errorf(codes.DeadlineExceeded, "request timedout")
	}

	//saving the aptop in in-memory store
	err := s.Store.Save(laptop)
	if err != nil {
		code := codes.Internal
		if errors.Is(err, ErrAlreadyExists) {
			code = codes.AlreadyExists
		}

		return nil, status.Errorf(code, "cannot save laptop to the store: %s", err)
	}

	//log the saved id
	log.Printf("Saved laptop with id: %s", laptop.Id)

	//prepare a createLaptopResponse
	response := &pb.CreateLaptopResponse{
		Id: laptop.Id,
	}

	return response, nil
}
