/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_a1_sortieren;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class SortTypes {

    private static final Logger LOG = LogManager.getLogger(SortTypes.class);

    public static void insertionSort2(final int[] a) {
        int elt;
        int j;
        for (int i = 0; i < a.length; i++) {
            elt = a[i];
            j = i;
            while (a[j - 1] > elt) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = elt;
        }
    }

    public static void selectionSort(final int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }
    }
    

    public static void bubblesort(final int[] a) {
        int temp;
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    
    public static void bubblesort2(final int[]a)
    {
        for(int i= 1; i < a.length; i++)
        {
            boolean nothingToBubble = true;
            for (int j = 0; j < a.length -1 -i; j++)
            {
                //LOG.debug("j = " + j);
                if (a[j] == a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    nothingToBubble = false;
                }
            }
            if(nothingToBubble)
            {
                break;
            }
        }
        
    }

}
