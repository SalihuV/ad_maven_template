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
final public class Car {

    private final int MINPARKING = 30;
    private final int parking;

    private Car() {
        this.parking = (int) (Math.random() + this.MINPARKING);
    }

    public Car createCar() {
        return new Car();
    }

    public int getParking() {
        return this.parking;
    }
}
