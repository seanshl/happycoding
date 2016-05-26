package com.Algorithms.LinkedLists;

import java.util.Stack;

import com.Utils.Node;

/**
 * Implement a function to check if a linked list is a palindrome.
 * @author liushiyao
 *
 */
public class Palindrome {

    public static boolean isPalindrome(Node head) {
        if (head == null) return false;

        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if (stack.pop() != slow.data) return false;
            slow = slow.next;
        }

        return true;
    }
    
    public static boolean checkPalindrome(Node head) {
        int length = head.length();
        
        PalResult res = recurse(head, length);
        
        return res.result;
    }
    /**
     * 思路
     * 1 2 3 4 3 2 1
     * 迭代的终止可以终止在结尾点，也可以终止在中点。当截止在中点时，可以考虑的方法是
     * 以总长度-2， 最终观察三个特殊值 ，-1， 0， 1可能作为base.
     * 结果要wrapper成一个类， 一个域为结果，一个域为继续往下推的节点。
     * @param head
     * @param length
     * @return
     */
    
    public static PalResult recurse(Node head, int length) {
        if (head == null || length <= 0) {
            return new PalResult(head, true);
        } else if (length == 1) {
            return new PalResult(head.next, true);
        }
        
        PalResult res = recurse(head.next, length - 2);
        
        if (!res.result || res.node == null) {
            return res;
        }
        
        res.result = (head.data == res.node.data);
        res.node = res.node.next;
        
        return res;
        
        
    }
}
