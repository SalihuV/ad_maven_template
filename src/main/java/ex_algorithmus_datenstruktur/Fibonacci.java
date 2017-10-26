/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_algorithmus_datenstruktur;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Valon
 */
public class Fibonacci {

    private static int x = 0;
    private static final Logger LOGGER = LogManager.getLogger(Fibonacci.class);
    private static final Map<Integer, Integer> results = new HashMap<>();

    public static int fiboRec1(int n) {
        if (n <= 0) {
            /*für negative Zahlen*/
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fiboRec1(n - 1) + fiboRec1(n - 2);
        }

    }

    public static int fiboRec2(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (results.get(n) != null) {
                return results.get(n);
            } else {
                int y = fiboRec2(n - 1) + fiboRec2(n - 2);
                results.put(n, y);
                return y;
            }
        }
    }

    public static int iterativFibo(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int i = 2;
            while (i <= n) {     // Schleife aller Werte von 2 bis n
                int a2 = b;      // Wert Fibo(i-1)
                int b2 = a + b;  // Wert Fibo(1)
                a = a2;          // Zwischenspeicher
                b = b2;          // Zwischenspeicher
                i++;
            }
            return b;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        /*fiboRec1*/
        Date date = new Date();
        LOGGER.info("fiboRec1 start:{}", sdf.format(date));
        for (int i = 0; i < 45; i++) {
            x = fiboRec1(i);
            LOGGER.info("x:{}", x);
        }
        Date fDate = new Date();
        LOGGER.info("end:{}", sdf.format(fDate));
        LOGGER.info("fiboRec2 start:{}", sdf.format(fDate));
        /*fiboRec2*/
        for (int i = 0; i < 45; i++) {
            x = fiboRec2(i);
            LOGGER.info("x:{}", x);
        }
        Date xDate = new Date();
        LOGGER.info("end:{}", sdf.format(xDate));
        LOGGER.info("iterativFibo start:{}", sdf.format(xDate));
        /*iterativFibo*/
        for (int i = 0; i < 45; i++) {
            x = iterativFibo(i);
            LOGGER.info("x:{}", x);
        }
        Date zDate = new Date();
        LOGGER.info("end:{}", sdf.format(zDate));
    }

}
