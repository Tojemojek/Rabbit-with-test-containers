# Rabbit-with-test-containers

## Start RabbitMQ in a container
```bash
cd ./docker
docker-compose up -d
```
Administration panel: http://localhost:15672/ (guest/guest)

## Initial setup
For the first time, you need to create exchanges, queues and bindings. 
- exchanges: `test-exchange` type Direct, `test-exchange-2` type Fanout
- queues: `test-queue-1`, `test-queue-2`, `test-queue-3`
- bindings: 
  - `test-exchange` to `test-routing-1` to `test-queue-1` 
  - `test-exchange` to `test-routing-2` to `test-queue-2` 
  - `test-exchange` to `test-routing-3` to `test-queue-3` 
  - `test-exchange` to `test-queue-1` 
  - `test-exchange` to `test-queue-2` 
  - `test-exchange` to `test-queue-3` 

