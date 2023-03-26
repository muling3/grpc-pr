package main

import (
	"flag"
	"fmt"
	"log"
	"net"

	"github.com.muling3/pb"
	sm "github.com.muling3/service_muling3" // servicepackage.. with no reason its refusing the package name thats why have renamed it to my name
	"google.golang.org/grpc"
)

func main() {
	port := flag.Int("port", 1000, "server port")
	flag.Parse()

	log.Printf("Startint the server on port: %d", *port)

	laptopServer := sm.NewLaptopServer(sm.NewInMemoryLaptopStore())

	grpcServer := grpc.NewServer()
	pb.RegisterLaptopServiceServer(grpcServer, laptopServer)

	addr := fmt.Sprintf("0.0.0.0:%d", *port)

	listener, err := net.Listen("tcp", addr)
	if err != nil {
		log.Fatal("error creating a tcp connection:", err)
	}

	err = grpcServer.Serve(listener)
	if err != nil {
		log.Fatal("cannot start server:", err)
	}
}
