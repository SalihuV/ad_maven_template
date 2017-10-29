/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

/**
 *
 * @author Valon
 * @param <T>
 */
public final class BoundedBuffer<T> {

    private final int capacity;
    private int readPos = 0; // tail
    private int writePos = 0; // head;
    private int size = 0;
    private final T[] buffer;

    private final Semaphore putSemaphore;
    private final Semaphore getSemaphore;

    public BoundedBuffer(final int capacity) {
        this.capacity = capacity;

        this.buffer = (T[]) new Object[capacity];

        this.putSemaphore = new Semaphore(capacity);

        this.getSemaphore = new Semaphore(0);
    }

    public boolean empty() {
        return this.size == 0;
    }

    public boolean full() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void put(final T element) throws InterruptedException {
        // wait for an empty slot to put the element
        putSemaphore.acquire();
        // put it into the buffer
        putElement(element);
        // notify all that the new element is available
        getSemaphore.release();
    }

    public void put(final T element, final long timeOutMillis) throws InterruptedException {
        // wait for an empty slot to put the element
        putSemaphore.acquire(timeOutMillis);
        // put it into the buffer
        putElement(element);
        // notify all that the new element is available
        getSemaphore.release();
    }

    public T get() throws InterruptedException {
        // wait until the element is available
        getSemaphore.acquire();
        // get the element from the buffer
        T element = getElement();
        // notify all that an empty slot is now available
        putSemaphore.release();
        return element;
    }

    public T get(final long timeOutMillis) throws InterruptedException {
        // wait until the element is available
        getSemaphore.acquire(timeOutMillis);
        // get the element from the buffer
        T element = getElement();
        // notify all that an empty slot is now available
        putSemaphore.release();
        return element;
    }

    private synchronized void putElement(final T element) {
        this.buffer[this.writePos] = element;
        this.writePos = (this.writePos + 1) % this.buffer.length;
        this.size++;
    }

    private synchronized T getElement() {
        T element = this.buffer[this.readPos];
        this.buffer[this.readPos] = null;
        this.size--;
        this.readPos = (this.readPos + 1) % this.buffer.length;
        return element;
    }

    private synchronized T front() {
        T element = this.buffer[0];
        this.buffer[0] = null;
        this.size--;
        return element;
    }

    private synchronized T back() {
        T element = this.buffer[this.buffer.length];
        this.buffer[this.buffer.length] = null;
        this.size--;
        return element;
    }

    private synchronized void push(T element) {
        if (!(this.buffer.length == this.size)) {
            this.buffer[size] = element;
            this.size++;
        }
    }

    private synchronized T pop() {
        T element = this.buffer[this.size];
        this.buffer[this.size] = null;
        this.size--;
        return element;
    }

}
