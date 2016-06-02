package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.Stack;

public class Hanoi {
    public void game() {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        
        towers[0].moveDisks(n,  towers[2], towers[1]);
    }
    
    private class Tower {
        private Stack<Integer> disks;
        private int index;
        public Tower(int i) {
            this.index = i;
            this.disks = new Stack<>();
        }
        
        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error");
            } else {
                disks.push(d);
            }
        }
        
        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }
        
        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }
    
    
}
