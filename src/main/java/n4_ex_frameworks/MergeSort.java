/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n4_ex_frameworks;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Valon
 */
public class MergeSort {

    public static void mergeSort(int array[], int threshold) {
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(array, threshold);
        pool.invoke(task);
    }

}
