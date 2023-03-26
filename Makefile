gen:
	@echo "Generating go file from proto files"
	protoc --proto_path=proto --go_out=.  proto/*.proto
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
