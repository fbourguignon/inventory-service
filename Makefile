docker-up:
	docker-compose up -d

docker-down:
	docker-compose down

build:
	./gradlew build && cd ..

start:
	@make build
	@make docker-up