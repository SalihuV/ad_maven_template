/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_a2_higher_sort_algorithm;

/**
 *
 * @author Valon
 */
public class SortTypes {
    public static void insertionSort(final Character[] a) {
        Character elt;
        int j;
        for (int i = 0; i < a.length; i++) {
            elt = a[i];
            j = i;
            while (j > 0 && a[j - 1] > elt) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = elt;
        }
    }


    private static void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        char t = a[right];
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;
            }
            while ((a[down] >= t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }
    }
    
    public static void quickInsertionSort(Character[] data, int m)
    {
        
    }
    
    public static void quickInsertionSort(Character[] a, int left, int right, int m)
    {
        int up = left;
        int down = right -1;
        char t = a[right];
        do{
            while(a[up] < t)
            {
                up++;
            }
            while(a[down] >= t && down > up)
            {
                down --;
            }
            if (up >= down)
            {
                break;
            }
            swap(a, up, down);
        } while(true);
        swap(a, up, right);
        if (left < up-1)
        {
            int from = left;
            int to = up-1;
            if(to-from + 1 > m)
            {
                quickInsertionSort(a, from, to, m);
            }
            else {
                insertionSort(a);
            }
                    
        }
        if(right > up +1)
        {
            int from = up + 1;
            int to = right;
            if (to- from + 1 > m)
            {
                quickInsertionSort(a,from,to,m);
            }else{
                insertionSort(a);
            }
        }
    }
        private static void swap(Character[] data, int a, int b) {
        char tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
}
}
