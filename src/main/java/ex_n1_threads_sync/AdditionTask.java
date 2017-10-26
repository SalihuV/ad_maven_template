/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n1_threads_sync;

import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class AdditionTask implements Runnable {

    static Logger LOG = LogManager.getLogger(AdditionTask.class);

    private Thread runThread;
    private int rangeBegin, rangeEnd;
    private boolean isStopped = false;

    public AdditionTask(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void Stop() {
        this.isStopped = true;
    }

    public boolean isStopped() {
        return this.isStopped;
    }

    @Override
    public void run() {
        int n = this.rangeEnd - this.rangeBegin;
        this.runThread = Thread.currentThread();

        long sum = 0;

        for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
            if (this.isStopped()) {
                LOG.info(runThread.getName() + ": interrputed.");
                break;
            }
            sum += i;
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(AdditionTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM" + n + " -> " + sum);
        }
    }

}
