/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Valon
 */
public class ParkSimulation {

    private static final Logger LOG = LogManager.getLogger(ParkSimulation.class);
    public static final boolean LOGGING = false;

    private static final int CAR_PARKS = 3;
    private static final int CAR_PARK_CAPACITY = 200;
    private static final int CARS_VISITING = 1000;

    private static final int MIN_WAIT_TIME = 1;
    private static final int MAX_WAIT_TIME = 5;

    private final List<CarPark> carParks = new ArrayList<>(CAR_PARKS);
    private final List<Car> cars = new ArrayList<>(CARS_VISITING);

    private int succeeded = 0;
    private int failed = 0;

    public static void main(String args[]) {
        new ParkSimulation().start();

    }

    private void start() {
        for (int i = 0; i < this.CAR_PARKS; i++) {
            this.carParks.add(new CarPark(this.CAR_PARK_CAPACITY, i + 1));
        }
        for (int i = 0; i < this.CARS_VISITING; i++) {
            this.cars.add(new Car(this.getParkingStrategy(i), i + 1));
        }

        ExecutorService execService = Executors.newFixedThreadPool(cars.size());
        CompletionService<Boolean> compService = new ExecutorCompletionService<>(execService);
        String simulation = String.format("%d car parks, %d spots per car park, %d cars visiting", this.CAR_PARKS, this.CAR_PARK_CAPACITY, this.CARS_VISITING);
        LOG.info(simulation);
        for (Car car : cars) {
            compService.submit(car);
        }
        try {
            for (int x = 0; x < this.CARS_VISITING; x++) {
                boolean success = compService.take().get();
                if (success) {
                    this.succeeded++;
                } else {
                    this.failed++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int quota = (int) (((float)this.succeeded / this.CARS_VISITING)*100);
        LOG.info(String.format("done, %d cars did park, %d cars did'nt park (%d%% success)",this.succeeded,this.failed, quota));
        execService.shutdown();
    }

    private ParkingStrategy getParkingStrategy(int i) {
        int s = i % 4;
        switch (s) {
            case 0:
                return new ClosestParkingStrategy(this.carParks);
            case 1:
                return new SequentialParkingStrategy(this.carParks);
            case 2:
                return new SequentialWaitingParkingStrategy(this.carParks);
            case 3:
                return new SearchLeastOccupiedParkingStrategy(this.carParks);
            default:
                return null;
        }
    }

}
