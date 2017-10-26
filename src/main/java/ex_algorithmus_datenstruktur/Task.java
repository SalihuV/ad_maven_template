/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_algorithmus_datenstruktur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;
/**
 *
 * @author Valon
 */
public class Task {
    private static final Logger LOGGER = LogManager.getLogger(Task.class);
    public static void task1() {
      
    }

    public static void task2() {

    }

    public static void task3() {
    }

    public static void task(final int n) throws InterruptedException {
        Date date = new Date();
        task1();
        task1();
        task1();
        task1();
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            for (int j = 0; j < n; j++) {
                task3();
                task3();
            }
        }
        Thread.sleep(10);
        LOGGER.info("n:{},date:{}",n,date.toString());

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1;i<8;i++)
        {
            new Task().task(i*10);
        }
    }
    
}
