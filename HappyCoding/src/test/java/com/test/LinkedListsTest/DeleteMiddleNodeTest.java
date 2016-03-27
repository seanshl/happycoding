package com.test.LinkedListsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.Algorithms.LinkedLists.DeleteMiddleNode;
import com.Exceptions.InvalidInputException;
import com.Utils.Node;

public class DeleteMiddleNodeTest {
    
    @Test
    public void testGet() {
        Node a = new Node(1);
        a.appendToTail(2);
        a.appendToTail(3);
         
        try {
            assertEquals(a.getNodeFromThis(0).data, 1);
            assertEquals(a.getNodeFromThis(1).data, 2);
            assertEquals(a.getNodeFromThis(2).data, 3);
            assertNull(a.getNodeFromThis(3));
        } catch (InvalidInputException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }
    
    @Test
    public void test() {
        Node a = new Node(1);
        a.appendToTail(2);
        a.appendToTail(3);
        a.appendToTail(4);
        
        try {
            Node second = a.getNodeFromThis(1);
            System.out.println(second.data);
            Node third = a.getNodeFromThis(2);
            System.out.println(third.data);
            
            DeleteMiddleNode.deleteMiddle(second);
            System.out.println(a.toString());
            assertEquals(a.toString(), "1->3->4");
            
            DeleteMiddleNode.deleteMiddle(second);
            System.out.println(second.toString());
            assertEquals(a.toString(), "1->4");
            
        } catch (InvalidInputException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
