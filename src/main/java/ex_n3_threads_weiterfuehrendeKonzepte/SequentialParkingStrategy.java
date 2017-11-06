/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Valon
 */
public class SequentialParkingStrategy implements ParkingStrategy {

    //private  Logger LOG = new LogManager.getLogger(SequentialParkingStrategy.class);
    private final List<CarPark> carParks;

    public SequentialParkingStrategy(List<CarPark> carParks){
        this.carParks = carParks;
    }
    
    @Override
    public Boolean park(Car car) throws Exception{
      
        for (CarPark carPark: this.carParks){
            if(carPark.getFreeParkingFields() <= 0){
                continue;
            }
        
        try {
            carPark.enter(car);
        } catch(IllegalStateException e)
        {  
            System.out.println("Error - Can'ts accessing the car park");
            //LOG.error("Error - Can't accessing the car park");
            return false;
        }
        try {
            Thread.sleep(car.getParking());
        } catch (InterruptedException e)
        {
            throw new InterruptedException(e.toString());
        }
        carPark.leave(car);
        return true;
        }
        System.out.println("No spot found in the car park with SequentialParkingStrategy for car " + car);
        //LOG.error("No spot found in the car park with SequentialParkingStrategy for car " + car);
        return false;
    }
            
}
