package com.test.TreesAndGraphs;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Algorithms.TreesAndGraphs.Graph;
import com.Algorithms.TreesAndGraphs.RouteBetweenNodes;
import com.Utils.Builder;

public class RouteBetweenNodesTest {
    @Autowired 
    private Builder builder;
    private RouteBetweenNodes test;
    
    @Before
    public void onInit() throws IOException {
        String path = "src/main/resources/graphs/DirectGraph1";
        Graph graph = builder.directedGraphNodeBuilder(path);
        
        test = new RouteBetweenNodes(graph);
    }
    
    @Test
    public void testConnected() {
        test.clear();
        assertTrue(test.DFSSearch(0, 1));
        test.clear();
        assertTrue(test.DFSSearch(3, 0));
        test.clear();
        assertTrue(test.DFSSearch(0, 3));
    }
    
    @Test
    public void testDisconnected() {
        test.clear();
        assertFalse(test.DFSSearch(2, 4));
    }
    
    @Test
    public void testConnected2() {
        test.clear();
        assertTrue(test.BFSSearch(0, 1));
        test.clear();
        assertTrue(test.BFSSearch(3, 0));
        test.clear();
        assertTrue(test.BFSSearch(0, 3));
    }
    
    @Test
    public void testDisconnected2() {
        test.clear();
        assertFalse(test.BFSSearch(2, 4));
    }


}
