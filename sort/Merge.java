package sort;

import java.util.Arrays;
import java.util.List;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{

    /**
     * Returns the sorted array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i-mid]=a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = r[j++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

    }

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}


    //public static void main(String[] args) {
    //  int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
    //        31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
    //      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    //
    // Test the sort
    //      testSort(sort(arr));
    //}

    //  public static void testSort(int[] arr) {
    //    for (int i=0; i<arr.length-1; i++) {
    //      if (arr[i] > arr[i+1]) {
    //        System.out.println("FAIL at index "+i);
    //      System.out.println(Arrays.toString(arr));
    //    return;
    //}
    //}
    //System.out.println("SUCCESS!");
    //}

    //}
