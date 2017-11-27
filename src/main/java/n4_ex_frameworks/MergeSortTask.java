/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n4_ex_frameworks;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Valon
 */
public class MergeSortTask extends RecursiveAction {

    private final int array[];
    private final int min;
    private final int length;
    private final int threshold;

    public MergeSortTask(int array[], int threshold) {
        this.array = array;
        this.min = 0;
        this.length = array.length;
        this.threshold = threshold;
    }

    private MergeSortTask(int array[], int min, int length, int threshold) {
        this.array = array;
        this.min = min;
        this.length = length;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (this.length - this.min + 1 <= this.threshold) {
            PartialInsertionSort.sortPartially(this.array, this.min, this.length);
        } else {
            int mid = this.min + (this.length - this.min) / 2;
            invokeAll(new MergeSortTask(this.array, this.min, mid, this.threshold), new MergeSortTask(this.array, mid, this.length, this.threshold));
            merge(this.min, mid, this.length);
        }
    }

    private void merge(int min, int mid, int max) {
        int buff[] = Arrays.copyOfRange(array, min, max);
        int readBuff = 0;
        int readArray = mid;
        int writeBuff = min;
        while (readBuff < buff.length) {
            if (readArray == max || buff[readBuff] < array[readArray]) {
                array[writeBuff++] = buff[readBuff++];
            } else {
                array[writeBuff++] = array[readArray++];
            }
        }
    }
}
