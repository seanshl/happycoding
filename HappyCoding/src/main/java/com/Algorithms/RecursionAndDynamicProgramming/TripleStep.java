package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.HashMap;

public class TripleStep {
    private HashMap<Integer, Integer> buffer;
    
    public TripleStep() {
        this.buffer = new HashMap<Integer, Integer> ();
        buffer.put(1, 1);
        buffer.put(2, 2);
    }

    public int ways(int steps) {
        if (steps <= 0) {
            return 0;
        }
        
        if (buffer.containsKey(steps)) {
            return buffer.get(steps);
        }
        
        int res = ways(steps - 1) + ways(steps - 2);
        buffer.put(steps, res);
        return res;
    }

}
