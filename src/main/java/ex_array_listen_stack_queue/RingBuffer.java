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
public class RingBuffer implements RingBufferInterface {

    private final int limit = 7;
    private final char[] buffer = new char[limit];
    private int head = 0;
    private int elementCount = 0;
    private int tail = 0;

    @Override
    public void enqueue(char x) {
        if (this.getCount() > 0 && this.head == this.tail) {
            throw new RuntimeException("Buffer is full");
        }
        this.buffer[this.head] = x;
        this.elementCount++;
        this.head = (this.tail + this.elementCount) % this.limit;

    }

    @Override
    public char dequeue() {
        if (this.getCount() == 0) {
            throw new RuntimeException("No items in the buffer");
        }
        char out = this.buffer[this.tail];
        this.elementCount--;
        this.tail = (this.tail + 1) % this.limit;
        return out;
    }

    @Override
    public int getCount() {
        return this.elementCount;
    }

    @Override
    public int getHead() {
        return this.head;
    }

    @Override
    public int getTail() {
        return this.tail;
    }

}
