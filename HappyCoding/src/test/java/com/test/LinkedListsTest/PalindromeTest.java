package com.test.LinkedListsTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

import com.Algorithms.LinkedLists.Palindrome;
import com.Utils.Node;

public class PalindromeTest {

    @Test
    public void testNull() {
        Node nullList = null;
        
        assertFalse(Palindrome.isPalindrome(nullList));
    }

    
    @Test
    public void testReal() {
        Node list = new Node(1);
        
        list.appendToTail(2);
        list.appendToTail(3);
        
        Node list2 = new Node();
        list2.appendToTail(1);
        list2.appendToTail(2);
        list2.appendToTail(3);
        
        list2.appendToTail(4);
        list.appendToTail(2);
        list.appendToTail(1);
        
        Node list3 = new Node();
        list3.appendToTail(1);
        list3.appendToTail(2);
        list3.appendToTail(2);
        list3.appendToTail(1);
        System.out.println(list.toString());
        assertTrue(Palindrome.isPalindrome(list));
        assertFalse(Palindrome.isPalindrome(list2));
        assertTrue(Palindrome.isPalindrome(list3));
    }

}
