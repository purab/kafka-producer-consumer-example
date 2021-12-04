
Use this command for kafka server

```docker-compose -f docker-compose.yml up```

stop docker images

```docker-compose -f docker-compose.yml down```

```docker exec -it kafka /bin/sh```

```cd /opt/kafka_2/```

create topic

```./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic mytopic```
```./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic demotopic```

see created topics - list
```./bin/kafka-topics.sh --list --zookeeper zookeeper:2181```