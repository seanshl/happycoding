package com.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Algorithms.TreesAndGraphs.SimpleGraphNode;

public class Builder {
    public static Graph directedGraphNodeBuilder(String path) throws IOException {
        File file = new File(path);
        
        Graph graph = null;
        SimpleGraphNode[] nodes = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            
            //build the list of head
            int length = Integer.parseInt(line);
            nodes = new SimpleGraphNode[length];
            for (int i = 0; i < length; i++) {
                nodes[i] = new SimpleGraphNode(i);
            }         
            
            int count = 0;
            while ((line = br.readLine()) != null) {
                String []strs = line.trim().split("\\s+|,\\s+");
                for (int i = 1; i < strs.length; i++) {
                    nodes[count].addChild(nodes[Integer.parseInt(strs[i])]);
                }     
                System.out.println(nodes[count]);
                count++;
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        graph = new Graph(nodes);
        return graph;
        
    }
    
    public static void main(String []args) {
        String path = "src/main/resources/graphs/DirectGraph1";
        try {
            directedGraphNodeBuilder(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
