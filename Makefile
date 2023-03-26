gen:
	@echo "Generating go file from proto files"
	protoc --proto_path=proto proto/*.proto  --go_out=. --go-grpc_out=. 
	@echo "DONE!"
	
server:
	@echo "Sarting server server.go"
	go run cmd/server/main.go --port 4000
	@echo "DONE!"

client:
	@echo "Sarting client main.go"
	go run cmd/client/main.go --addr 0.0.0.0:4000
	@echo "DONE!"

clean:
	@echo "Cleaning ./pb folder"
	rm pb/*.go
	@echo "DONE!"

test: 
	@echo "Running all tests"
	go test -cover -race ./...
	@echo "DONE!"
	
run:
	go run main.go
	@echo "DONE!"
