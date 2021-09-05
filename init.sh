#!/bin/bash

SCRIPT_DIR="$( cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
function log_blue() { printf "\x1B[94m>> $1\x1B[39m\n"; }

function create-network() {
    log_blue "Create network..."
  docker network create  cqrs-es
}

function axon-server-start() {
   log_blue "axonserver starting..."
   docker run -d --name axon-server -p 8024:8024 -p 8124:8124 --network cqrs-es --restart always axoniq/axonserver:latest
}

function mysql-start() {
   log_blue "mysql starting..."
   docker run -it -d --name mysql-container -p 3306:3306 --network cqrs-es -e MYSQL_ROOT_PASSWORD=password --restart always -v mysql_data_container:/var/lib/mysql mysql:latest
}

function mongo-start() {
   log_blue "mongo starting..."
   docker run -it -d --name mongo-container -p 27017:27017 --network cqrs-es --restart always -v mongodb_data_container:/data/db mongo:latest
}

function neo4j-start() {
   log_blue "neo4j starting..."
    docker run -it -id --name neo4j -p 7474:7474 -p 7687:7687 --network cqrs-es -e NEO4J_AUTH=neo4j/password neo4j
}

function rabbitmq() {
   log_blue "rabbitmq starting..."
   docker run -d --hostname rabbitmq --network cqrs-es --name rabbitmq rabbitmq:3
}

