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
public class ClosestParkingStrategy implements ParkingStrategy {
    
    private static final Logger LOG = LogManager.getLogger(ClosestParkingStrategy.class);
    private final CarPark carPark;
    
    public ClosestParkingStrategy(List<CarPark> carParks)
    {
        this.carPark = carParks.get(0);
    }
    
    @Override
    public Boolean park(Car car ) throws InterruptedException
    {
        try {
            this.carPark.enter(car);
        } catch(IllegalStateException e)
        {
            LOG.error("Error - Can't accessing the car park.");
            return false;
        }
        try{
            Thread.sleep(car.getParking());
        } catch(InterruptedException e)
        {
            throw new InterruptedException(e.toString());
        }
        carPark.leave(car);
        return true;
    }
    
}
