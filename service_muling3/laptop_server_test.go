package service_muling3

import (
	"context"
	"testing"

	"github.com.muling3/pb"
	"github.com.muling3/sample"
	"github.com/stretchr/testify/require"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

func TestLaptopServer(t *testing.T) {

	laptopWithoutID := sample.NewLaptop()
	laptopWithoutID.Id = ""

	invalidLaptopID := sample.NewLaptop()
	invalidLaptopID.Id = "invalid-id"

	duplicateLaptopID := sample.NewLaptop()
	duplicatedStore := NewInMemoryLaptopStore()
	err := duplicatedStore.Save(duplicateLaptopID)
	require.Nil(t, err)

	testCases := []struct {
		name   string
		laptop *pb.Laptop
		store  LaptopStore
		code   codes.Code
	}{
		{
			name:   "success with id",
			laptop: sample.NewLaptop(),
			store:  NewInMemoryLaptopStore(),
			code:   codes.OK,
		},
		{
			name:   "success without id",
			laptop: laptopWithoutID,
			store:  NewInMemoryLaptopStore(),
			code:   codes.OK,
		},
		{
			name:   "inavlid id laptop",
			laptop: invalidLaptopID,
			store:  NewInMemoryLaptopStore(),
			code:   codes.InvalidArgument,
		},
		{
			name:   "duplicate laptop id",
			laptop: duplicateLaptopID,
			store:  duplicatedStore,
			code:   codes.AlreadyExists,
		},
	}

	for i := range testCases {
		tc := testCases[i]

		t.Run(tc.name, func(t *testing.T) {
			t.Parallel()

			// create the laptop request from the test cases
			request := &pb.CreateLaptopRequest{
				Laptop: tc.laptop,
			}

			server := NewLaptopServer(tc.store)

			res, err := server.CreateLaptop(context.Background(), request)

			if tc.code == codes.OK {
				require.NoError(t, err)
				require.NotNil(t, res)
				require.NotEmpty(t, res.Id)
				if len(res.Id) > 0 {
					require.Equal(t, tc.laptop.Id, res.Id)
				}
			}else{
				require.Error(t, err)
				require.Nil(t, res)
				stat, ok := status.FromError(err)
				require.True(t, ok)
				require.Equal(t, tc.code, stat.Code())
			}
		})
	}
}
