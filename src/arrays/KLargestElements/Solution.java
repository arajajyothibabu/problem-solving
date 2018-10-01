package arrays.KLargestElements;
import common.Printer;
import common.sorting.QuickSort;

import static common.Utils.arrayMinIndex;
import static common.Utils.reverse;
import static common.Utils.swap;

public class Solution {

    /**
     * Brute force worst solution :)
     * Worst case complexity O((n - k) * O(Sorting Algorithm(k)))
     * @param array
     * @param k
     * @return
     */
    static Integer[] kLargest(Integer[] array, Integer k) {
        Integer[] largest = new Integer[k];
        Integer i = 0;
        while(i < array.length){
            if(i == 0){
                while(i < k){
                    largest[i] = array[i];
                    i++;
                }
                largest = QuickSort.sort(largest);
            }
            if(largest[0] < array[i]){
                largest[0] = array[i];
                largest = QuickSort.sort(largest);
            }
            i++;
        }
        return reverse(largest);
    }

    /**
     * Through K Array Min
     * Worst case complexity O((n - k) * k))
     * @param array
     * @param k
     * @return
     * @throws Exception
     */
    static Integer[] kLargest2(Integer[] array, Integer k) throws Exception {
        Integer[] largest = new Integer[k];
        Integer i = 0, minIndex;
        while(i < array.length){
            if(i == 0){
                while(i < k){
                    largest[i] = array[i];
                    i++;
                }
            }
            minIndex = arrayMinIndex(largest);
            if(array[i] > largest[minIndex]){
                largest[minIndex] = array[i];
            }
            i++;
        }
        return reverse(QuickSort.sort(largest));
    }

    /**
     * Modified Bubble Sort
     * Worst case complexity O(nk)
     * @param array
     * @param k
     * @return
     */
    static Integer[] kLargest3(Integer[] array, Integer k) {
        for(Integer i = 0; i < k; i++){
            for(Integer j = 0; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j, j+ 1);
                }
            }
        }
        Integer[] output = new Integer[k];
        for(Integer i = 0; i < k; i++){ //returning last k elements
            output[i] = array[array.length - 1 - i];
        }
        return output;
    }

    public static void main(String[] args) throws Exception {

        Integer[] input = {1, 23, 12, 9, 30, 2, 50};
        Printer.printArray(kLargest(input, 3));
        Printer.printArray(kLargest2(input, 3));
        Printer.printArray(kLargest3(input, 3));

    }

}
