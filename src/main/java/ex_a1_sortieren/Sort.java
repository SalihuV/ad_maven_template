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
        int[] selectionSortdata = new int[40000];

        for (int i = 0; i < selectionSortdata.length; i++) {
            selectionSortdata[i] = ThreadLocalRandom.current().nextInt(0, 400000);
        }

        start = System.currentTimeMillis();
        SortTypes.selectionSort(selectionSortdata);
        logTime("Random selection sort", start);

        int[] insertionSortData = new int[40000];
        for (int i = 0; i < insertionSortData.length; i++) {
            insertionSortData[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.insertionSort2(insertionSortData);
        logTime("Random insertion sort", start);

        int[] bubbleSortData = new int[40000];
        for (int i = 0; i < bubbleSortData.length; i++) {
            bubbleSortData[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.bubblesort(bubbleSortData);
        logTime("Random bubble sort", start);

        int[] bubbleSortData2 = new int[40000];
        for (int i = 0; i < bubbleSortData2.length; i++) {
            bubbleSortData2[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.bubblesort2(bubbleSortData2);
        logTime("Random bubble sort2", start);

        int[] datashellsort = new int[40000];
        for (int i = 0; i < datashellsort.length; i++) {
            datashellsort[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        start = System.currentTimeMillis();
        SortTypes.shellSort(datashellsort);
        logTime("Random shell sort", start);
    }
}
