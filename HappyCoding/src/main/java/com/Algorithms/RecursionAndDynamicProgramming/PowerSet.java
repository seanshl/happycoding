package com.Algorithms.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Write a method to return all subsets of a set.
 * @author liushiyao
 *
 */
public class PowerSet {
    
    public ArrayList<ArrayList<Integer>> method1(ArrayList<Integer> set) {
        if (set == null) return null;
        return getSubsets(set, 0);
    }
    
    
    private ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set ,int index) {
        ArrayList<ArrayList<Integer>> result;
        if (set.size() == index) {
            result = new ArrayList<>();
            
            result.add(new ArrayList<>());
        } else {
            result  = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = 
                    new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset: result) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            
            result.addAll(moresubsets);
        }
        
        return result;
    }
}
