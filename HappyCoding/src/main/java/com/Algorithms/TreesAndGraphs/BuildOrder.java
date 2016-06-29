package com.Algorithms.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {
    
    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        
        for (String project :  projects) {
            graph.getOrCreateNode(project);
        }
        
        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            
            graph.addEdge(first, second);
        }
        
        return graph;
    }
    
    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.dependencies == 0) {
                order[offset++] = project;
            }
        }
        
        return offset;
    }
    
    Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        
        int endOfList = this.addNonDependent(order, projects, 0);
        
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            
            if (current == null) return null;
            
            ArrayList<Project> children = current.children;
            for (Project child : children) {
                child.dependencies--;
            }
            
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        
        return order;
    }
    
    
    public class Graph {
        public ArrayList<Project> nodes = new ArrayList<>();
        
        public HashMap<String, Project> map = new HashMap<>();
        
        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            
            return map.get(name);
        }
        
        public void addEdge(String startName, String endName) {
            Project start = this.getOrCreateNode(startName);
            Project end = this.getOrCreateNode(endName);
            
            start.addNeighbor(end);
        }
    }
    
    public class Project {
        public String name;
        
        public ArrayList<Project> children = new ArrayList<>();
        
        public HashMap<String, Project> map = new HashMap<>();
        
        public int dependencies = 0;
        
        public Project(String name) {
            this.name = name;
        }
        
        public void addNeighbor(Project node) {
            if (!map.containsKey(node.name)) {
                children.add(node);
                dependencies++;
            }
        }
    }
}
