package com.Algorithms.LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //Moore voting!
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>[] list = new LinkedList[3];
        for (int i = 0; i <list.length; i++) {
            list[i] = new LinkedList<>();
        }

        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean added = false;
            for (int j = 0; j < 3; j++) {
                if (peek(list[j]) == nums[i]) {
                    list[j].add(nums[i]);
                    added= true;
                    break;
                }
            }   

            if (added) continue;
            pointer = pointer(list);

            if (pointer == -1) {
                deleteOne(list);
                continue;
            } else {
                pointer = pointer(list);
                list[pointer].add(nums[i]);
                continue;
            }
        }

        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEmpty()) {
                res.add(list[i].get(0));
            }
        }

        return res;
    }

    private void deleteOne(List<Integer>[] list) {
        for (int i = 0; i < list.length; i++) {
            remove(list[i]);
        }
    }

    private boolean full(List<Integer>[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].isEmpty()) return false;
        }

        return true;
    }

    private int pointer(List<Integer>[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    private void remove(List<Integer> list) {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

    private Integer peek(List<Integer> list) {
        if(!list.isEmpty()) {
            return list.get(list.size() - 1);
        }

        return null;
    }
}
