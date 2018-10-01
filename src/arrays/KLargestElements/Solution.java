package arrays.KLargestElements;
import common.Printer;
import common.sorting.QuickSort;

import static common.Utils.reverse;

public class Solution {

    /**
     * Brute force
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

    public static void main(String[] args) {

        Integer[] input = {1, 23, 12, 9, 30, 2, 50};
        Printer.printArray(kLargest(input, 3));

    }

}
