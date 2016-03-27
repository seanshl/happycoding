package com.test.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import com.Algorithms.TreesAndGraphs.ListOfDepths;
import com.Utils.BinaryTreeNode;
import com.Utils.TreeBuilder;

public class ListOfDepthsTest {

    public static void main(String []args) {
        String[] input = new String[] {"1","#","2","3"};
        BinaryTreeNode head = TreeBuilder.create(input);
        TreeBuilder.out(head);
        
        ListOfDepths test = new ListOfDepths();
        ArrayList<LinkedList<BinaryTreeNode>> list = test.createLists2(head);
        
        System.out.println(list.size());
        list.stream().forEach(level -> {
            level.stream().forEach(x -> {
                System.out.print(x.value + " -> " );
            });
            System.out.println();
        });
    }
}
