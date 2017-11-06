/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import java.util.concurrent.Callable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Valon
 */
public final class Car implements Callable<Boolean> {

    private static final Logger LOG = LogManager.getLogger(Car.class);
    private final static int MINPARKING = 30;
    private final int parking;
    private final ParkingStrategy pStrategy;
    private int carNumber = 0;

    public Car(ParkingStrategy strategy, int cNumber) {
        this.parking = (int) (Math.random() + this.MINPARKING);
        this.pStrategy = strategy;
        this.carNumber = cNumber;
    }

    public int getParking() {
        return this.parking;
    }
    
    @Override
    public Boolean call() throws Exception{
        return this.pStrategy.park(this);
    }
    
    @Override
    public String toString()
    {
        return "Car Number " + this.carNumber;
    }
}
