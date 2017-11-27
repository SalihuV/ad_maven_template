/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n4_ex_frameworks;

/**
 *
 * @author Valon
 */
public class PartialInsertionSort {

    public static void sortPartially(int[] items, int from, int to) {
        for (int s = from + 1; s < to; s++) {

            for (int i = s; i > from && items[i] < items[i - 1]; i--) {
                swap(items, i, i - 1);
            }

        }
    }

    private static void swap(int[] items, int temp1, int temp2) {
        int tmp = items[temp1];
        items[temp1] = items[temp2];
        items[temp2] = tmp;
    }

}
