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
public interface Synch {

    /**
     * Eintritt in einen geschützen Bereich erlangen, falls kein Zutritt möglich
     * ist warten.
     *
     * @throws InterruptedException, wenn dsa Warten unterbrochen wird
     */
    public void acquire() throws InterruptedException;

    /**
     * Freigabe des geschützen Bereichs.
     */
    public void release();

}
