package common.sorting;

import common.Printer;

import static common.Utils.swap;

public class QuickSort {

    public static Integer[] sort(Integer[] arr){
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    static private void quickSort(Integer[] arr, Integer low, Integer high){
        if(low < high){
            Integer pivot = arr[high], j = low - 1;
            for(Integer i = low; i <= high - 1; i++){
                if(arr[i] <= pivot){
                    j++;
                    swap(arr, i, j);
                }
            }
            swap(arr, j + 1, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 2, high);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 7, 8, 9, 1, 5 };
        Printer.printArray(arr);
        Printer.printArray(sort(arr));
    }

}
