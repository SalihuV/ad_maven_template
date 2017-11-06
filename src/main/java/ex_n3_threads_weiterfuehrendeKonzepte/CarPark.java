/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

/**
 *
 * @author Valon
 */
public class CarPark<T> {

    private final int CAPACITY = 200;
    private int reservedPlaces = 0;
    private final Semaphore getInSemi;
    private final Semaphore getOutSemi;
    private final T[] cars;

    public CarPark() {
        this.cars = (T[]) new Object[this.CAPACITY];

        this.getInSemi = new Semaphore(this.CAPACITY);

        this.getOutSemi = new Semaphore(0);
    }

    public boolean empty() {
        return this.reservedPlaces == 0;
    }

    public boolean full() {
        return this.reservedPlaces == this.CAPACITY;
    }

    public int getSize() {
        return this.reservedPlaces;
    }

    public void put(final T element, final int timeOutMillis) throws InterruptedException {
        this.getInSemi.acquire(timeOutMillis);
        putElement(element);
        this.getOutSemi.release();
    }

    public void put(final T element) throws InterruptedException {
        this.getInSemi.acquire(0);
        putElement(element);
        this.getOutSemi.release();
    }

    public T get() throws InterruptedException {
        this.getOutSemi.acquire(0);
        T element = getElement();
        this.getOutSemi.release();
        return element;
    }

    private synchronized void putElement(final T element) {
        this.cars[this.CAPACITY - this.reservedPlaces] = element;
        this.reservedPlaces++;
    }

    private synchronized T getElement() {
        T element = this.cars[this.CAPACITY - this.reservedPlaces];
        this.reservedPlaces--;
        return element;
    }

}
