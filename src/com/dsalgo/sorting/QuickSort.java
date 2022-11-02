package com.dsalgo.sorting;

public class QuickSort {
    void sort(int arr[],int l, int h)
    {
        if(l<h){
            int p = partition(arr,l,h);
            sort(arr,l,p-1);
            sort(arr,p,h);
        }
    }

    private int partition(int[] arr, int l, int h) {
        int pivot = arr[h];

        int i = l-1;
        for (int j = l; j < h; j++) {
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }

    private void swap(int[] arr, int j, int h) {
        int temp = arr[j];
        arr[j]  = arr[h];
        arr[h] = temp;
    }

    //sc-O(log n)
    //tail call elimination
    public void quickSort(int arr[], int low, int high)
    {
        while (low < high)
        {
            int pi = partition(arr, low, high);

            // If left part is smaller, then recur for left
            // part and handle right part iteratively
            if (pi - low < high - pi)
            {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            }

            // Else recur for right part
            else
            {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13,13, 5, 6 };

        QuickSort ob = new QuickSort();
        ob.sort(arr,0,arr.length-1);

        printArray(arr);
    }
};


