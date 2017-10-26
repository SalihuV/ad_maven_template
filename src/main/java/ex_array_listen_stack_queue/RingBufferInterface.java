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
public interface RingBufferInterface {
    
    void enqueue(char r);
    char dequeue();
    int getCount();
    int getHead();
    int getTail();
    
}
