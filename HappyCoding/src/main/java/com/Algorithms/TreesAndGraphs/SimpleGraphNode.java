package com.Algorithms.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraphNode {
	public int name;
	public List <SimpleGraphNode> adjacents;
	
	public SimpleGraphNode(int name) {
	    this.name = name;
	    this.adjacents = new ArrayList<SimpleGraphNode> ();
	}
	
	public void addChild(SimpleGraphNode child) {
	    this.adjacents.add(child);
	}
	
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append("name: ");
	    str.append(name);
	    str.append(" children: ");
	    for (SimpleGraphNode child : adjacents) {
	        str.append(" ");
	        str.append(child.name);
	    }
	    return str.toString(); 
	}
}
