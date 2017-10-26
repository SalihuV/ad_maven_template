/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

/**
 *
 * @author Valon
 */
public class List implements ListIterator {

    private Node head;
    private int count = 0;

    @Override
    public void add(Allocation alloc) {
        Node x = new Node(alloc);
        x.setNextNode(head);
        this.head = x;
        this.count++;

    }

    @Override
    public Node remove(Node tempNode) {
        this.count--;
        return this.head = tempNode.getNextNode();

    }

    @Override
    public Node iterativRemove(Node tempNode) {
        if (tempNode.hasNextNode()) {
            Node x = tempNode.getNextNode();
            Node y = x.getNextNode();
            tempNode.setNextNode(y);
        } else {
            tempNode.setNextNode(null);
        }
        count--;
        return tempNode;
    }

    @Override
    public int getSize() {
        return this.count;
    }
}
