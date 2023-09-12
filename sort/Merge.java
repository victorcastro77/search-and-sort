package sort;

import java.util.Arrays;

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
  public static int[] sort(int[] arr) {
    int inputLength = arr.length;
    
    if (inputLength < 2) {
        return arr;
    }
    int mid = inputLength/2;
    int[] l = new int[mid];
    int[] r = new int[inputLength - mid];
    for (int i = 0; i < mid; i++) {
        l[i]=arr[i];
    }
    for (int i = mid; i < inputLength; i++) {
        r[i-mid]=arr[i];
    }
    
    sort(l);
    sort(r);
    
    merge(arr, l, r);
    return arr;
  }
  
  private static void merge (int[] arr, int[] l, int[]r) {
      int leftSize = l.length;
      int rightSize = r.length;
      int i = 0, j = 0, k = 0;
      
      while(i < leftSize && j < rightSize) {
          if (l[i] <= r[i]) {
              arr[k] = l[i];
              i++;
          }
          else {
              arr[k] = r[j];
          }
          k++;
      }
      while (i < leftSize) {
          arr[k] = l[i];
          i++;
          k++;
      }
      while (j < rightSize) {
          arr[k] = l[j];
          j++;
          k++;
      }
  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr));
  }
  
  public static void testSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
      if (arr[i] > arr[i+1]) {
        System.out.println("FAIL at index "+i);
        System.out.println(Arrays.toString(arr));
        return;
      }
    }
    System.out.println("SUCCESS!");
  }

}