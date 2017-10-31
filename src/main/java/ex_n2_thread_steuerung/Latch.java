/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class Latch implements Synch {

    private static final Logger LOG = LogManager.getLogger(Latch.class);
    boolean isStarted = false;

    @Override
    public synchronized void acquire() throws InterruptedException {
        while (!this.isStarted) {
            this.wait();
        }
    }

    @Override
    public synchronized void release() {
        this.isStarted = true;
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(Latch.class.getName()).log(Level.SEVERE, null, ex);

        }
        this.notifyAll();
    }
}
