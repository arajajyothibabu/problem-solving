package sorting;
import static common.Utils.printArray;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 */
public class CountingInversions {

    static long merge(int arr[], int low, int mid, int high){
        long swaps = 0;
        int i = low, j = mid + 1, k = 0;
        int[] tempArr = new int[high - low + 1];
        while (i <= mid || j <= high){
            if(i > mid){
                tempArr[k++] = arr[j++];
            }else if(j > high){
                tempArr[k++] = arr[i++];
            }else if(arr[i] <= arr[j]){
                tempArr[k++] = arr[i++];
            }else {
                tempArr[k++] = arr[j++];
                swaps += mid - i + 1;
            }
        }
        for(int z = 0; z < k; z++){
            arr[low + z] = tempArr[z];
        }
        return swaps;
    }

    static long mergeSort(int arr[], int low, int high){
        long swaps = 0;
        if(low < high){
            int mid = (low + high) / 2;
            System.out.println(low + "-" + high);
            swaps += mergeSort(arr, low, mid);
            swaps += mergeSort(arr, mid + 1, high);
            swaps += merge(arr, low, mid, high);
        }
        return swaps;
    }

    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 1};
        System.out.println(countInversions(arr));
    }
}
