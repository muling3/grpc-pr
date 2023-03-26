package service_muling3

import (
	"context"
	"net"
	"testing"

	"github.com.muling3/pb"
	"github.com.muling3/sample"
	"github.com.muling3/serializer"
	"github.com/stretchr/testify/require"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

func TestLaptopClient(t *testing.T) {
	t.Parallel()

	laptopServer, address := startTestLaptopServer(t)
	laptopClient := newLaptopClient(t, address)

	laptop := sample.NewLaptop()
	laptopID := laptop.Id

	request := &pb.CreateLaptopRequest{
		Laptop: laptop,
	}
	res, err := laptopClient.CreateLaptop(context.Background(), request)
	require.NoError(t, err)
	require.NotEmpty(t, res)
	require.Equal(t, laptopID, res.Id)

	//confirm that the laptop was saved
	created_laptop, err := laptopServer.Store.Find(laptop)
	require.NoError(t, err)
	require.NotNil(t, created_laptop)

	//comfirming that the created and original laptop are same
	requireLaptopsToBeEqual(t, created_laptop, laptop)
}

func startTestLaptopServer(t *testing.T) (*LaptopServer, string) {
	laptopServer := NewLaptopServer(NewInMemoryLaptopStore())

	grpcServer := grpc.NewServer()
	pb.RegisterLaptopServiceServer(grpcServer, laptopServer)

	listener, err := net.Listen("tcp", ":0")
	require.NoError(t, err)

	go grpcServer.Serve(listener)

	return laptopServer, listener.Addr().String()
}

func newLaptopClient(t *testing.T, addr string) pb.LaptopServiceClient {
	conn, err := grpc.Dial(addr, grpc.WithTransportCredentials(insecure.NewCredentials()))

	require.NoError(t, err)
	return pb.NewLaptopServiceClient(conn)
}

func requireLaptopsToBeEqual(t *testing.T, current *pb.Laptop, original *pb.Laptop) {
	json1, err := serializer.ProtobufToJSON(current)
	require.NoError(t, err)

	json2, err := serializer.ProtobufToJSON(original)
	require.NoError(t, err)

	require.Equal(t, json1, json2)
}
