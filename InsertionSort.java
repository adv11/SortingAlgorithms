package Sorting;
import java.util.Scanner;
/*
TC = O(N^2)
Auxiliary Space = O(1)
Boundary Case = When array is sorted in reverse order then it takes max time.
When array is already sorted then it takes min time
Sorting in place = YES
Stable = YES
*/
public class InsertionSort {
    // method for insertion sort
    public static void insertionSort(int[] array){
        int n = array.length;
        for(int i=1 ; i<n ; i++){   // start from 1 index
            int key = array[i]; // element which we have to put into sorted part
            int j = i-1;    // start traversing from i-1 position to 0th position

            // while j>=0 and array[j]>key
            while(j>=0 && array[j]>key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
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

            insertionSort(array);
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
