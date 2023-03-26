package main

import (
	"context"
	"flag"
	"log"
	"time"

	"github.com.muling3/pb"
	"github.com.muling3/sample"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/credentials/insecure"
	"google.golang.org/grpc/status"
)

func main() {
	addr := flag.String("addr", "0.0.0.0:1000", "client address")
	flag.Parse()

	log.Printf("Startint client on addresss: %s", *addr)

	conn, err := grpc.Dial(*addr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatal("cannot dial client", err)
	}

	laptopClient := pb.NewLaptopServiceClient(conn)
	laptop := sample.NewLaptop()

	request := &pb.CreateLaptopRequest{
		Laptop: laptop,
	}


	//creating a timeout context
	ctx, cancel := context.WithTimeout(context.Background(), 4 * time.Second)
	defer cancel()

	response, err := laptopClient.CreateLaptop(ctx, request)
	if err != nil {

		st, ok := status.FromError(err)
		if ok && st.Code() == codes.AlreadyExists {
			log.Printf("laptop already exists: %s", err)
		} else {
			log.Printf("error creating laptop: %s", err)
		}

		return
	}

	log.Printf("laptop created successfully: \nlaptop.ID = %s", response.Id)
}
