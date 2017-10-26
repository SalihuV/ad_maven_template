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
public interface ListIterator {

    /*add new Node*/
    public void add(Allocation alloc);

    /*remove the first node*/
    public Node remove(Node node);

    /*remove a node*/
    public Node iterativRemove(Node node);

    /*count List*/
    public int getSize();

}
