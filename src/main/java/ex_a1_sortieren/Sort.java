/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_a1_sortieren;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class Sort {

    private static final Logger LOG = LogManager.getLogger(Sort.class);

    public static void logTime(String name, long start) {
        LOG.info(name + " took " + (System.currentTimeMillis() - start) + "ms to perform.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        long start;
        int[] data = new int[40000];

        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(0, 400000);
        }

        start = System.currentTimeMillis();
        SortTypes.selectionSort(data);
        logTime("Random insertion sort", start);

        int[] data2 = new int[40000];
        for (int i = 0; i < data2.length; i++) {
            data2[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.selectionSort(data2);
        logTime("Random selection sort", start);

        int[] data3 = new int[40000];
        for (int i = 0; i < data3.length; i++) {
            data3[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.bubblesort(data3);
        logTime("Random bubble sort", start);

        int[] data4 = new int[40000];
        for (int i = 0; i < data4.length; i++) {
            data4[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.bubblesort2(data4);
        logTime("Random bubble sort2", start);

    }
}
