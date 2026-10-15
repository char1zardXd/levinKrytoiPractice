package pr2;

import java.util.Arrays;

public class Main {
     public static void bubbleSort (int[] array){
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
     }

     public static void sort(int[] array) {
         if (array == null || array.length <= 1) {
             return;
         }

         int[] temp = new int[array.length];
         mergeSort(array, 0, array.length, temp);
     }

     public static void mergeSort(int [] array, int lo, int hi, int[] temp) {
         if (hi - lo <= 1) {
             return;
         }

         int mid = lo + (hi - lo) / 2;
         mergeSort(array, lo, mid, temp);
         mergeSort(array, mid, hi, temp);
         merge(array, lo, mid, hi, temp);
     }

     public static void merge(int[] array, int lo, int mid, int hi, int[] temp) {
         int i = lo;
         int j = mid;
         int k = lo;

         while(i < mid && j < hi) {
             if(array[i] <= array[j]) {
                 temp[k++] = array[i++];
             } else {
                 temp[k++] = array[j++];
             }
         }

         while(i < mid) {
             temp[k++] = array[i++];
         }

         while(j < hi) {
             temp[k++] = array[j++];
         }

         System.arraycopy(temp, lo, array, lo, hi - lo);
     }

     public static int linearSearch(int[] array, int key) {
         for(int i = 1; i < array.length; i++) {
             if(array[i] == key) {
                 return i;
             }
         }
         return -1;
     }

     public static int binarySearch(int[] array, int key) {
         int low = 0;
         int hi = array.length - 1;

         while(low <= hi) {
             int mid = low + (hi - low) / 2;
             if(array[mid] == key) {
                 return mid;
             } else if (array[mid] < key) {
                 low = mid + 1;
             } else {
                 hi = mid - 1;
             }
         }
         return -1;
     }

    private static void testLinearSearch(int[] array, int key) {
        int index = linearSearch(array, key);
        if (index != -1) {
            System.out.println("Ключ " + key + " знайдено за індексом: " + index);
        } else {
            System.out.println("Ключ " + key + " не знайдено");
        }
    }

    private static void testBinarySearch(int[] array, int key) {
        int index = binarySearch(array, key);
        if (index != -1) {
            System.out.println("Ключ " + key + " знайдено за індексом: " + index);
        } else {
            System.out.println("Ключ " + key + " не знайдено");
        }
    }

     public static void main (String[] args) {
         int[] array = {9, 4, 2, 7, 1, 6};
         System.out.println("Невідфільтрований масив: " + Arrays.toString(array));
         bubbleSort(array);
         System.out.println("Відфільтрований масив бульба: " + Arrays.toString(array));

         int[] array2 = {9, 4, 2, 7, 1, 6};
         sort(array2);
         System.out.println("Відфільтрований масив злиттям: " + Arrays.toString(array2));

         int[] array3 = {9, 4, 2, 7, 1, 6};
         testLinearSearch(array3, 7);
         testLinearSearch(array3, 99);
         testBinarySearch(array2, 7);
         testBinarySearch(array2, 99);
    }
}