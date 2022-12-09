package com.dsalgo;

public class KthLargestNumber {

    public static void main(String[] args) {
        int arr[] = {4,1,6,2,8};
        //int result = findKthLargestElement(arr,3);
        int result = findKthLargestElementHeap(arr,3);
        System.out.println("Kth largest element is " + result);
    }

    private static int findKthLargestElementHeap(int[] arr, int k) {
        MaxHeap maxHeap= new MaxHeap(arr,k);
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < maxHeap.ptr[0]){
                maxHeap.ptr[0] = arr[i];
                maxHeap.maxHeapify(0);
            }
        }
        return maxHeap.ptr[0];
    }

    private static int findKthLargestElement(int[] arr, int k) {

        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            l = Math.min(l,arr[i]);
            h = Math.max(h,arr[i]);
        }

        while(l<h){
            int m = l+(h-l)/2;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] <= m){
                    count++;
                }
            }
            if(count < k){
                l = m +1;
            }else{
                h = m;
            }
        }
        return l;

    }

    static class MaxHeap{
        int[] ptr;
        int cap;
        int heap_size;

        int parent(int i){
            return (i-1)/2;
        }

        int left(int i){
            return ((2*i)+1);
        }

        int right(int i){
            return ((2*i)+2);
        }
        MaxHeap(int arr[], int size){
            heap_size = size;
            ptr = arr;
            int i = (heap_size-1) /2;
            while(i >=0){
                maxHeapify(i);
                i--;
            }
        }
        void maxHeapify(int i){
            int l = left(i);
            int r = right(i);
            int biggest = i;
            if(l < heap_size && ptr[l] > ptr[i]){
                biggest = l;
            }

            if(r < heap_size && ptr[r] > ptr[biggest]){
                biggest = r;
            }
            if(biggest != i){
                int temp = ptr[i];
                ptr[i] = ptr[biggest];
                ptr[biggest] = temp;
                maxHeapify(biggest);
            }
        }
    }
}
