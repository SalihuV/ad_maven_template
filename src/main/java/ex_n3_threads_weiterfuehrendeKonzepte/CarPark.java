/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Valon
 */
public class CarPark {
    
    private static final Logger LOG = LogManager.getLogger(CarPark.class);
    private final int capacity;
    private final int number;
    private int occupied = 0;
    
    public CarPark(final int capacity, final int number) {
        this.capacity = capacity;
        this.number = number;
    }
    
    public boolean empty() {
        return this.occupied == 0;
    }
    
    public boolean full() {
        return this.occupied == this.capacity;
    }
    
    public int getFreeParkingFields() {
        return this.capacity - this.occupied;
    }
    
    public synchronized void enter(Car car) throws InterruptedException {
        if (this.getFreeParkingFields() <= 0) {
            this.wait();
        }
        if (this.occupied < this.capacity) {
            this.occupied++;
            LOG.info(car + " entered " + this);
        } else {
            throw new IllegalStateException("It's full, sorry mate");
        }
    }
    
    public synchronized void leave(Car car) {
        this.occupied--;
        this.notifyAll();
        LOG.info(car + " left " + this);
    }
    
    @Override
    public String toString()
    {
        return String.format("CAR PARK #%d, %d/%d occupied",this.number,this.occupied,this.capacity);
    }
}
