package service_muling3

import (
	"errors"
	"fmt"
	"sync"

	"github.com.muling3/pb"
	"github.com/jinzhu/copier"
)

var ErrAlreadyExists = errors.New("laptop Already Exists")

type LaptopStore interface {
	Save(*pb.Laptop) error
	Find(*pb.Laptop) (*pb.Laptop, error)
}

type InMemoryLaptopStore struct {
	mutex sync.RWMutex
	data  map[string]*pb.Laptop
}

func NewInMemoryLaptopStore() *InMemoryLaptopStore {
	return &InMemoryLaptopStore{
		data: make(map[string]*pb.Laptop),
	}
}

// implementng the save method of the interface
func (store *InMemoryLaptopStore) Save(laptop *pb.Laptop) error {
	store.mutex.Lock()
	defer store.mutex.Unlock()

	//check if the laptop id exists in the data in memory
	if store.data[laptop.Id] != nil {
		return ErrAlreadyExists
	}

	//perform deep copying of the laptop object
	new_laptop := &pb.Laptop{}
	err := copier.Copy(new_laptop, laptop)

	if err != nil{
		return fmt.Errorf("cannot copy laptop: %s", err)
	}

	store.data[new_laptop.Id] = new_laptop
	return nil
}


// find functionality to check whether the laptop was stored inMemory
func (store *InMemoryLaptopStore) Find(laptop *pb.Laptop) (*pb.Laptop, error) {
	store.mutex.RLock()
	defer store.mutex.RUnlock()

	//check if the laptop id exists in the data in memory
	if store.data[laptop.Id] == nil {
		return nil, nil
	}

	//perform deep copying of the laptop object
	new_laptop := &pb.Laptop{}
	err := copier.Copy(new_laptop, laptop)

	if err != nil{
		return nil, fmt.Errorf("cannot copy laptop: %s", err)
	}

	return new_laptop, nil
}

