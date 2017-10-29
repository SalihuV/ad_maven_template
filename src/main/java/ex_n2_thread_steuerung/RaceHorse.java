/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Random;

/**
 *
 * @author Valon
 */
public class RaceHorse implements Runnable {

    private static final Logger LOG = LogManager.getLogger(RaceHorse.class);
    private final Synch startSignal;
    private volatile Thread runThread;
    private final Random random;

    public RaceHorse(Synch startSignal) {
        this.startSignal = startSignal;
        this.random = new Random();
    }

    @Override
    public void run() {
        runThread = Thread.currentThread();
        LOG.info("Rennpferd" + runThread.getName() + "geht in die Box");
        try {
            startSignal.acquire();
            LOG.info("Rennpferd " + runThread.getName() + " geht in die Box.");
            Thread.sleep(random.nextInt(3000));
            LOG.info("Rennpferd " + runThread.getName() + " ist im Ziel.");
        } catch (InterruptedException ex) {
            LOG.debug(ex);
            LOG.info("Rennen wurde abgebrochen");
        }
    }

}
