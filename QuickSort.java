package Sorting;
import java.util.Scanner;
/*
Worst TC : O(N^2) when array is already sorted
Best TC : O(N * log N) when partition pivot elements divides whole array into equal parts
in place sorting : YES
stable : Not stable
*/
public class QuickSort {
    // method for swapping the elements
    public static void swap(int[] array, int i, int j){
        array[i] = array[i] ^ array[j] ^ (array[j] = array[i]); // one liner swapping
    }
    // method for partitioning the array into two parts for applying quick sort in both parts
    public static int partition(int[] array, int low, int high){
        int pivot = array[low]; // take first element of the array as your pivot element
        int i=low, j=high;
        while(i < j){
            while(array[i] <= pivot && i<high){   // if A[i] <= pivot then i++
                i++;
            }
            while(array[j] >= pivot && j>low){   // if A[j] >= pivot then j--
                j--;
            }
            if(i < j){  // if i < i then swap A[i] and A[j]
                swap(array, i, j);
            }
        }
        swap(array, j, low);    // at last swap A[j] and pivot element
        return j;   // return index of the pivot element for applying recursive calls on both parts
    }
    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivotIndex = partition(array, low, high);   // for storing index of the pivot element
            quickSort(array, low, pivotIndex-1);    // apply quickSort from 0 to pivot's index - 1
            quickSort(array, pivotIndex+1, high);   // from pivot's index + 1 to high
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();
            System.out.println("Enter the elements of the array:");
            int[] array = new int[size];
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            quickSort(array, 0, array.length-1);
            for(int ele : array){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
