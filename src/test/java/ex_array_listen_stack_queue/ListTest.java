/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valon
 */
public class ListTest {

    @Test
    public void getSize1() {
        List l = new List();
        Allocation a = new Allocation(0, 2);
        Allocation a1 = new Allocation(1, 3);
        l.add(new Allocation(0, 2));
        l.add(new Allocation(1, 3));
        assertEquals(2, l.getSize());
    }

    @Test
    public void TestAllocStartAddr() {

        Allocation a = new Allocation(0, 2);
        assertEquals(0, a.getStartAddr());

    }

    @Test
    public void TestAllocSize() {
        Allocation a = new Allocation(0, 2);
        assertEquals(2, a.getSize());
    }

    @Test
    public void TestNodeSetNextNode() {
        Node n = new Node(new Allocation(0, 2));
        Node temp = new Node(new Allocation(1, 3));
        n.setNextNode(temp);
        assertEquals(true, temp.equals(n.getNextNode()));
    }

    @Test
    public void TestNodeGetAllocation() {
        Allocation a = new Allocation(0, 2);
        Node n = new Node(a);
        assertEquals(true, a.equals(n.getAllocation()));
    }

}
