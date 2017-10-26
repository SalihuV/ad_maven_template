/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

import java.util.Objects;

/**
 *
 * @author Valon
 */
public class Node {

    private Allocation alloc;
    private Node nextNode;

    public Node(Allocation allocation) {
        this.alloc = allocation;
    }

    public void setNextNode(Node n) {
        this.nextNode = n;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public boolean hasNextNode() {
        if (this.getNextNode() != null) {
            return true;
        } else {
            return false;
        }
    }

    public Allocation getAllocation() {

        return this.alloc;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Allocation)) {
            return false;
        }
        final Allocation ac = (Allocation) other;
        return (alloc.getStartAddr() == ac.getStartAddr()) && (alloc.getSize() == ac.getSize());

    }

    @Override
    public int hashCode() {
        return Objects.hash(Integer.valueOf(alloc.getStartAddr()), Integer.valueOf(alloc.getSize()));
    }

}
