package com.Algorithms.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a directed graph, design an algo to find out whether there is a route between two nodes.
 * @author liushiyao
 *
 */
public class RouteBetweenNodes {
    
    private Graph graph;
    boolean [] visited;
    
    public void clear() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public RouteBetweenNodes(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.nodes.length];
    }
    
    public SimpleGraphNode getNode(int index) {
        if (index < graph.nodes.length) {
            return graph.nodes[index];
        } else {
            return null;
        }
    }
    
    public boolean DFSSearch(int root, int target) {
        SimpleGraphNode rootNode = getNode(root);
        if (rootNode == null) {
            return false;
        } 
        if (rootNode.name == target) {
            return true;
        }
        visited[root] = true;
        
        for (SimpleGraphNode node: rootNode.adjacents) {
            if (!visited[node.name]) {
               return DFSSearch(node.name, target);
            }
        }
        return false;
    }
    
    public boolean BFSSearch(int root, int target) {
        if (target == root) {
            return true;
        }
        Queue<SimpleGraphNode> queue = new ArrayDeque<SimpleGraphNode>();
        queue.add(getNode(root));
        
        while(!queue.isEmpty()) {
            SimpleGraphNode rootNode = queue.remove();

            visited[root] = true;
            for (SimpleGraphNode node: rootNode.adjacents) {
                if (node.name == target) {
                    return true;
                }
                if (!visited[node.name]) {
                    visited[node.name] = true;
                    queue.add(node);
                }
            }
            
        }
        
        return false;
    }
    
    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

}
