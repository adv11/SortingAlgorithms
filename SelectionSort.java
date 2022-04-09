package Sorting;
import java.util.Scanner;
/*
TC = O(N^2)
Auxiliary Space = O(1)
Selection sort never takes more than O(N) swaps that's why it can be used when memory write is costly operation.
*/
public class SelectionSort {
    public static void selectionSort(int[] array){
        int n = array.length;
        for(int i=0 ; i<n-1 ; i++){ // loop from 0 to n-1
            int min = i;    // for finding the index of the minimum element present in unsorted part

            // searching in unsorted part of the array
            for(int j=i+1 ; j<n ; j++){
                if(array[j] < array[min]){  // if array[j] < array[min] then update min with j
                    min = j;
                }
            }
            // if min == i then it means that the minimum element is already present in its proper place so there is
            // no need to swap the elements else swap elements
            if(min != i){
                array[i] = array[i] ^ array[min] ^ (array[min] = array[i]); // one liner swapping
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

            selectionSort(array);
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
