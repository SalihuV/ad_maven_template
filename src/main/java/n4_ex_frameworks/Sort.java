/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n4_ex_frameworks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

/**
 *
 * @author Valon
 */
public class Sort {

    private static final Logger LOG = LogManager.getLogger(Sort.class);

    public static void logTime(String name, long start) {
        LOG.info(name + " toook " + (System.currentTimeMillis() - start) + "ms to perform.");
    }

    public static int[] randomArray(int testSize, int min, int max) {
        Random random = new Random(System.currentTimeMillis());
        int array[] = new int[testSize];
        for (int i = 0; i < testSize; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long start;
        final int TEST_SIZE = 100_000_000;
        final int[] THRESHOLDS = new int[]{22, 24, 45, 56, 65, 77, 100};
        for (int threshold : THRESHOLDS) {
            int[] array = randomArray(TEST_SIZE, 0, TEST_SIZE);
            start = System.currentTimeMillis();
            MergeSort.mergeSort(array, threshold);
            logTime("MergeSort ", start);
        }
    }

}
