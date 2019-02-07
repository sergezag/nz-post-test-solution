package com.nzposttest.jgrapht;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.stereotype.Component;

/**
 * ShortestPathDAG for North South Railway application that allows the user to
 * enter a start and end station (which could be the same station) and then
 * calculate details of the shortest route
 *
 * @author serge
 */
@Component
public class RailwayNetwork {

    public static enum Town {
        A, B, C, D, E, F, G, H, I, J;
    }

    /*
     * default graph instance
     */
    private Graph<Town, DefaultWeightedEdge> graph;

    /*
     * shortest path algorithm
     */
    private ShortestPathAlgorithm<Town, DefaultWeightedEdge> shortestPathAlgorithm;

    /**
     * default constructor - initializes default graph with test data.
     */
    public RailwayNetwork() {
        this.graph = 
                new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        Graphs.addEdgeWithVertices(this.graph, Town.A, Town.B, 12);
        Graphs.addEdgeWithVertices(this.graph, Town.A, Town.D, 19);
        Graphs.addEdgeWithVertices(this.graph, Town.A, Town.E, 20);
        Graphs.addEdgeWithVertices(this.graph, Town.A, Town.G, 16);
        Graphs.addEdgeWithVertices(this.graph, Town.B, Town.C, 5);
        Graphs.addEdgeWithVertices(this.graph, Town.B, Town.D, 13);
        Graphs.addEdgeWithVertices(this.graph, Town.B, Town.I, 15);
        Graphs.addEdgeWithVertices(this.graph, Town.C, Town.D, 5);
        Graphs.addEdgeWithVertices(this.graph, Town.D, Town.E, 7);
        Graphs.addEdgeWithVertices(this.graph, Town.E, Town.F, 5);
        Graphs.addEdgeWithVertices(this.graph, Town.F, Town.A, 5);
        Graphs.addEdgeWithVertices(this.graph, Town.G, Town.F, 11);
        Graphs.addEdgeWithVertices(this.graph, Town.H, Town.A, 4);
        Graphs.addEdgeWithVertices(this.graph, Town.H, Town.G, 6);
        Graphs.addEdgeWithVertices(this.graph, Town.H, Town.B, 19);
        Graphs.addEdgeWithVertices(this.graph, Town.I, Town.H, 21);
        Graphs.addEdgeWithVertices(this.graph, Town.I, Town.J, 10);
        Graphs.addEdgeWithVertices(this.graph, Town.J, Town.B, 7);
        Graphs.addEdgeWithVertices(this.graph, Town.J, Town.C, 15);

        this.shortestPathAlgorithm = 
                new DijkstraShortestPath<Town, DefaultWeightedEdge>(this.graph);
    }

    /**
     * constructor - initializes takes graph to be used.
     */
    RailwayNetwork(Graph g) {
        this.graph = g;
        this.shortestPathAlgorithm = 
                new DijkstraShortestPath<Town, DefaultWeightedEdge>(this.graph);
    }

    /**
     * finds shortest route in the network
     *
     * @param src source of the given route, eg A
     * @param dest destination of the given route, eg B
     * @return the shortest distance as String, eg AB12
     */
    public String shortestRoute(Town src, Town dest) {
        GraphPath<Town, DefaultWeightedEdge> path = 
                this.shortestPathAlgorithm.getPath(src, dest);

        String route = path.getVertexList().stream()
            .map(town -> town.name())
            .collect(Collectors.joining());

        return route + Math.round(path.getWeight());
    }

    /**
     * @return the graph
     */
    protected Graph<Town, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    /**
     * Loads graph form given comma delimted list of paths
     * @param routes
     * @return the graph created form the loaded comma delimited list
     * AB12,BD3,EF15 etc
     */
    public static Graph<Town, DefaultWeightedEdge> loadGraphFromInputString(
            final String routes) {
        
        Objects.requireNonNull(routes, "Loaded routes cannot be null");
        List<String> routesList = Arrays.asList(routes.split(","));

        Graph<Town, DefaultWeightedEdge> graphFromInput
                = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        routesList.forEach((route) -> {
            Town u = Town.valueOf(route.substring(0, 1));
            Town v = Town.valueOf(route.substring(1, 2));
            String w = route.substring(2, route.length());
            Graphs.addEdgeWithVertices(
                    graphFromInput, u, v, Double.parseDouble(w));
        });

        return graphFromInput;
    }
}
