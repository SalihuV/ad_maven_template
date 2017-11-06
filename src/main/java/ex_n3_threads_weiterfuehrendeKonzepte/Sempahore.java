/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n3_threads_weiterfuehrendeKonzepte;

/**
 *
 * @author Valon
 */
public class Sempahore {

    private int semi;

    public Sempahore(final int init) {
        this.semi = init;
    }

    public synchronized void acquire() throws InterruptedException {
        while (this.semi == 0) {
            this.wait();
        }
        this.semi--;
    }

    public synchronized void release() {
        this.notifyAll();
        this.semi++;
    }
}
