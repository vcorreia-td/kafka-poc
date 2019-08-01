# kafka-poc

Simple POC for validating Kafka-Spring in Kotlin.

# How to run

1. `docker-compose up zookeeper kafka`
2. Run the application (I'm running "uncontainered")
    a. Via IntellJ
    b. Or via gradle `./gradewl bootRun`
3. If you want to see stuff happenning in Kafka, you can set up commandline consumer:
    `docker exec -it <kafka_container> ./usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic my_topic`
    
     
    