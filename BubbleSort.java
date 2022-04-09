package Sorting;

import java.util.Scanner;

public class BubbleSort {
    // method for swapping elements
    public static void swap(int[] array, int i, int j){
        array[i] = array[i] ^ array[j] ^ (array[j] = array[i]); // one liner swapping
    }
    // Brute Force : Bubble Sort (Not Optimised)
    // It runs one pass extra until it checks if the array is sorted or not in that pass
    public static void bubbleSort_notOptimised(int[] array){
        int n = array.length;
        for(int i=0 ; i<n-1 ; i++){ // run loop till n-1 index
            for(int j=0 ; j<(n-i-1) ; j++){ // ith number of elements are always sorted from last of the array, So run loop till
                // (n-i-1)th element from the start of the array
                if(array[j+1] < array[j]){  // if A[j+1} < A[j] then swap elements
                    swap(array, j+1, j);
                }
            }
        }
    }
    // Optimised Bubble Sort
    public static void bubbleSortOptimised(int[] array){
        int n = array.length;
        for(int i=0 ; i<n-1 ; i++){
            boolean isSwapped = false;  // for optimisation purpose
            for(int j=0 ; j<n-i-1 ; j++){
                if(array[j+1] < array[j]){
                    swap(array, j+1, j);
                    isSwapped = true;   // if swapping takes place then assign true to isSwapped
                }
            }
            if(!isSwapped){ // if means no swapping takes place that means array is sorted now so break the loop
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcase:");
        int testCases = sc.nextInt();
        while (testCases-- > 0){
            System.out.println("Enter size of the array:");
            int size = sc.nextInt();

            int[] array = new int[size];
            System.out.println("Enter elements of the array:");
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            // bubbleSort_notOptimised(array);
            bubbleSort_notOptimised(array);
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
