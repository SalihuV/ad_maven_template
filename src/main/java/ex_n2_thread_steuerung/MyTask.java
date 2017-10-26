/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Valon
 */
public final class MyTask implements Runnable {
    
    private static final Logger LOG = LogManager.getLogger(MyTask.class);
    
    private final Object lock;
    
    public MyTask(final Object lock) {
        this.lock = lock;
    }
    
    @Override
    public void run() {
        LOG.info("Warten...");
        synchronized (lock) {
            try {
                wait();
            } catch (InterruptedException ex) {
                return;
            }
        }
        LOG.info("...aufgewacht");
    }
    
}
