/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_hashTables;

/**
 *
 * @author Valon
 * @param <E>
 */
public class simpleHashSet<E> implements simpleHashSetInterface<E> {

    private final Node[] node;
    private final int size;

    public simpleHashSet(int size) {
        this.size = size;
        this.node = new Node[size];

    }

    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(E e) {
        final int index = e.hashCode() % this.size;
        if (this.node[index] != null) {
            this.node[index].setNextNode(e);

        } else {
            this.node[index] = new Node<>(e);
        }

    }

    @Override
    public E get(int hashcode) {
        final int index = hashcode % this.size;
        if (this.node[index] != null) {
            return (E) this.node[index];
        } else {
            return null;
        }

    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void remove(Object o) {

    }
}
