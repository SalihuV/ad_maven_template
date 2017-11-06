/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 *
 * @author Valon
 */
public class SequentialWaitingParkingStrategy implements ParkingStrategy {

    private static final Logger LOG = LogManager.getLogger(SequentialWaitingParkingStrategy.class);
    private final List<CarPark> carParks;
    private boolean hasWaited = false;
    private final int WaitTime = 1500;

    public SequentialWaitingParkingStrategy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    @Override
    public Boolean park(Car car) throws InterruptedException {
        for (CarPark carPark : this.carParks) {
            if (carPark.getFreeParkingFields() <= 0 && !hasWaited) {
                Thread.sleep(WaitTime);
                if (carPark.getFreeParkingFields() <= 0) {
                    continue;
                }

            }
            try {
                carPark.enter(car);
            } catch (IllegalStateException e) {
                LOG.error("Error - Can't accessing the car park.");
                return false;
            }
            try {
                Thread.sleep(car.getParking());
            } catch (InterruptedException e) {
                throw new InterruptedException(e.toString());

            }
            carPark.leave(car);
            return true;
        }
        LOG.error("No spot found in the car parks with SequentialWaitingPakringStrategy for car " + car);
        return false;
    }
}
