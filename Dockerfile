FROM openjdk:11
VOLUME /tmp
EXPOSE 8091
ADD ./target/api-foto-cassandra-0.0.1-SNAPSHOT.jar api-foto-cassandra.jar
ENTRYPOINT ["java","-jar","/api-foto-cassandra.jar"]