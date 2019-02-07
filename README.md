# NZ Post Test Solution


## Build & Run Requirements

### Tested with
* Java 8
* apache-maven 3.6

### To Build
In the project folder execute

mvn install

### To Run
In the project folder execute

mvn spring-boot:run

The application runs at https://localhost//get-shortest-route/route/{query}

## Overview
NZPost Test application is developed in JAVA8 for the requirements of the NZPost Developer Coding task. 
It calculates the details of the shortest route for the given start and end station for the provided traffic network observed as directed graph. In the graph each node represents the station and the edge route between two stations where the edge weights represents 
the distance to travel between two stations.

The provided solution uses Dijkstra's Shortest Path algorithm (http://mathworld.wolfram.com/DijkstrasAlgorithm.html). 
Dijkstra's algorithm is an algorithm for finding a graph geodesic, i.e., the shortest path between two graph vertices in a graph. 
It functions by constructing a shortest-path tree from the initial vertex to every other vertex in the graph. 
The worst-case running time for the Dijkstra algorithm on a graph with n nodes and m edges is O(n^2) because it allows for directed cycles.

Dijkstra Algortithm implementation is provided by JGraphT library, which is a Java library of graph theory data structures 
and algorithms (https://jgrapht.org/). JGraphT is mature library that provides robust API for graph generation and manipulation.

The application allows for the source and the destination nodes to be entered as letters A to J, it returns shortest path found in the loaded test data.

For example if the source and the destination are A,B the solution is AB12 or for the query B,I the solution is BIJ25. The application also handles the situation where the source and the destination are the same letter thus the query A,A returns AA0 as the shortest path.

For the convience purposes the solution is exposed as a web service using Springboot libary. It runs on default 8080 port. It provides get-shortest-route call
/get-shortest-route/route/{query}

For example
http://localhost:8080/get-shortest-route/route/B,J
returns shortest path  {"BIJ25"}

Potentially this solution can be improved by adding a post call that supplies the graph data to be queried alongside the query string.

In the long run the solution can be further improved by using a persistent data source such as Neo4J Database https://neo4j.com. Neo4J also provides robust query language Cypher (https://neo4j.com/cypher-graph-query-language/) that can be used to retrieve the shortest paths directly from the Neo4J datasource as demonstrated at https://neo4j.com/graphgist/santas-shortest-weighted-path.

In terms of scalability this solution can scale vertically by increasing the system resources such as memory.

Horizontal scalability can be achieved by using infrastructure such as AWS elastic container or AWS web instance configured as auto scaling group (https://docs.aws.amazon.com/autoscaling/ec2/userguide/AutoScalingGroup.html) further fronted by AWS load balancer.


