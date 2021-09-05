## CQRS-EventSourcing Demo

![arch.png](arch.png)

Basic architecture

- Tests will be adding.
- Docker profile doesn't exist for now it will be adding.

### Introduction

- Spring Cloud Functions
- Spring Cloud Stream RabbitMQ
- Axon Framework
- Spring Security Oauth2
- Prometheus
- WebFlux


### Local

In order to run the project, you must pass the Spring profile("dev").

You must have MySQL, MongoDB, Neo4j and Axon Server on your computer.

### Kubernetes

```
cd music-service/music-cmd-api
docker build -t music-command-api .

cd music-service/music-query-api
docker build -t music-query-api .

cd recommendation-service/reco-query-service
docker build -t reco-query-api  .

cd user-service/user-cmd-api
docker build -t user-command-api .

cd user-service/user-query-api
docker build -t user-query-api .

cd user-service/oauth2-server
docker build -t oauth2-server .

```


- Traefik
```
helm repo add traefik https://helm.traefik.io/traefik
helm install traefik traefik/traefik
kubectl port-forward $(kubectl get pods --selector "app.kubernetes.io/name=traefik" --output=name) 9000:9000

kubectl apply -f k8s/ingress/ingress.yaml
```

- Mongo
```
kubectl apply -f k8s/mongo/service.yaml
kubectl apply -f k8s/mongo/mongodb-statefulset.yaml

#for cluster
kubectl exec --stdin --tty mongosts-0    -- /bin/sh
mongo

rs.initiate({ _id: "rs0", version: 1,
members: [
  { _id: 0, host: "mongosts-0.mongodb-service.default.svc.cluster.local:27017" },
  { _id: 1, host: "mongosts-1.mongodb-service.default.svc.cluster.local:27017" },
  { _id: 2, host: "mongosts-2.mongodb-service.default.svc.cluster.local:27017" } ]});

```

- Mysql
```
kubectl apply -f k8s/mysql/cluster/configmap.yaml
kubectl apply -f k8s/mysql/cluster/service.yaml
kubectl apply -f k8s/mysql/cluster/mysql-statefulset.yaml
```

- Neo4j
```
kubectl apply -f k8s/neo4j/values.yaml
helm install neo4j-release neo4j/neo4j-standalone -f values.yaml
```


- RabbitMQ
```
kubectl krew install rabbitmq
kubectl rabbitmq create rabbitmq-cluster
```