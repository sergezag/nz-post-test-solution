package com.nzposttest.jgrapht;

import com.nzposttest.jgrapht.RailwayNetwork.Town;
import java.util.ArrayList;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author serge
 */
public class RailwayNetworkTest {


    private final RailwayNetwork railwayNetwork = new RailwayNetwork();

 
    @Test
    public void testRoutes() {
        assertEquals("A0", this.railwayNetwork.shortestRoute(Town.A, Town.A));
        assertEquals("AB12", this.railwayNetwork.shortestRoute(Town.A, Town.B));
        assertEquals("JB7", this.railwayNetwork.shortestRoute(Town.J, Town.B));
        assertEquals("HABIJ41", this.railwayNetwork.shortestRoute(Town.H, Town.J));
    }

}
