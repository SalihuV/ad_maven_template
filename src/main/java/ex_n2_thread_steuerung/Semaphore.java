/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

/**
 *
 * @author Valon
 */
public class Semaphore {

    private int semaphores;

    public Semaphore(final int init) {
        this.semaphores = init;
    }

    public synchronized void acquire() throws InterruptedException {
        while (this.semaphores == 0) {
            this.wait();

        }
        this.semaphores--;
    }

    public synchronized void acquire(final long timeOutMillis) throws InterruptedException {
        while (this.semaphores == 0) {
            this.wait(timeOutMillis);
        }
        this.semaphores--;
    }

    public synchronized void release() {
        this.notifyAll();
        this.semaphores++;
    }
}
