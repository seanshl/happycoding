package com.Utils;

import java.util.LinkedList;

public class TreeBuilder {
    public static BinaryTreeNode create(String[] l) {
        if (l.length == 0) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(l[0]));
        BinaryTreeNode p = root;
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        int i = 1;
        boolean left = true;
        while (i < l.length) {
            if (l[i].equals("#")) {
                if (left) {
                    p.left = null;
                } else {
                    p.right = null;
                    p = queue.poll();
                }
            } else {
                if (left) {
                    p.left = new BinaryTreeNode(Integer.parseInt(l[i]));
                    queue.push(p.left);
                } else {
                    p.right = new BinaryTreeNode(Integer.parseInt(l[i]));
                    queue.push(p.right);
                    p = queue.poll();
                }
            }
            left = !left;
            i ++;
        }
        return root;
    }
    
    public static void out(BinaryTreeNode root) { 
        if (root == null) {
            System.out.println("#");
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.push(root);
        BinaryTreeNode p = root;
        System.out.print(p.value);
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(",");
            if (p.left != null) {
                queue.push(p.left);
                System.out.print(p.left.value);
            } else {
                System.out.print("#");
            }
            System.out.print(",");
            if (p.right != null) {
                queue.push(p.right);
                System.out.print(p.right.value);
            } else {
                System.out.print("#");
            }
        }
        System.out.println();
    }
}