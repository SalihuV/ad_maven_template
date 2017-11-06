/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;

/**
 *
 * @author Valon
 */
public class SearchLeastOccupiedParkingStrategy implements ParkingStrategy {

    private static final Logger LOG = LogManager.getLogger(SearchLeastOccupiedParkingStrategy.class);
    private final List<CarPark> carParks;

    public SearchLeastOccupiedParkingStrategy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    @Override
    public Boolean park(Car car) throws InterruptedException {

        CarPark leastOccupiedCarPark = null;
        for (CarPark cp : carParks) {
            if (leastOccupiedCarPark == null || cp.getFreeParkingFields() > leastOccupiedCarPark.getFreeParkingFields()) {
                leastOccupiedCarPark = cp;
            }
        }
        if (leastOccupiedCarPark != null && leastOccupiedCarPark.getFreeParkingFields() > 0) {
            try {
                leastOccupiedCarPark.enter(car);

            } catch (IllegalStateException e) {
                LOG.error("Error - Can't accessing the car park.");
                return false;
            }
            try {
                Thread.sleep(car.getParking());

            } catch (InterruptedException e) {
                throw new InterruptedException(e.toString());
            }
            leastOccupiedCarPark.leave(car);
            return true;
        }
        LOG.error("Nothing founded in the car parks SearchLeastOccupiedParkingStrategy for car " + car);
        return false;
    }
}
