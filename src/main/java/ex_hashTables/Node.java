/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_hashTables;

import ex_array_listen_stack_queue.*;
import java.util.Objects;

/**
 *
 * @author Valon
 */
public class Node<E> {

    private E store;
    private Node nextNode;

    public Node(E e) {
        this.store = e;
    }

    public E getByHash(int hashCode) {
        if (this.store.hashCode() == hashCode) {
            return this.store;
        } else if (this.getNextNode() == null) {
            return null;
        } else {
            return (E) this.getNextNode().getByHash(hashCode);
        }
    }

    public void setNextNode(E e) {
        if (e.equals(this.store)) {
            this.store = e;
        }
        if (this.hasNextNode()) {
            this.getNextNode().setNextNode(e);
        } else {
            this.setNextNode((E) new Node<E>(e));

        }

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

    public E getAllocation() {

        return this.store;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(Integer.valueOf(this.toString()));
    }
/*
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
*/
}
