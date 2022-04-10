package Sorting;
import java.util.Scanner;
/*
TC(Worst/Best/Average) : O(N * log N)
Auxiliary space : O(N)
Sorting in place : NO
Stable : YES
*/
public class MergeSort {
    // method for dividing the array into smaller sub arrays
    public static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            // recursive call 1
            mergeSort(array, low, mid);
            // recursive call 2
            mergeSort(array, mid+1, high);
            // call for merging the sub arrays
            merge(array, low, mid, high);
        }
    }
    // method for merging the sub arrays
    public static void merge(int[] array, int low, int mid, int high){
        // i -> for traversing in left sub array
        // j -> for traversing in right sub array
        // k -> for traversing in tempArray
        int i=low, j=mid+1, k=low;
        int[] tempArray = new int[array.length];    // temporary space for storing sorted elements

        while(i<=mid && j<=high){
            // append smaller elements into tempArray and increase k pointer and respective pointer whose value is smaller
            if(array[i] < array[j]){
                tempArray[k] = array[i];
                i++;
            }else{
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }
        // This means left sub array is completely traversed
        if(i > mid){
            while(j <= high){
                tempArray[k] = array[j];
                j++;
                k++;
            }
        }else{  // This means right sub array is completely traversed
            while(i <= mid){
                tempArray[k] = array[i];
                i++;
                k++;
            }
        }
        // Coping elements from tempArray to given array
        for(k=low ; k<=high ; k++){
            array[k] = tempArray[k];
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

            mergeSort(array, 0, array.length-1);
            for(int ele : array){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
