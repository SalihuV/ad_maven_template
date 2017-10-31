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
public final class DemoWaitPool {

    private static final Object lock = new Object();

    public static void main(final String args[]) throws InterruptedException {
        MyTask waiter = new MyTask(lock);
        new Thread(waiter).start();
        Thread.sleep(1000);
        synchronized (lock) {
            lock.notifyAll();
        }

    }
}
