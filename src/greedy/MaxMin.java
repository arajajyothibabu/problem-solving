package greedy;

/**
 * https://www.hackerrank.com/challenges/angry-children
 */
public class MaxMin {

    static void sort(int[] arr, int low, int mid, int high){
        int[] merged = new int[high - low + 1];
        int k = 0;
        for(int i = low, j = mid + 1; i <= mid || j <= high;){
            if(j > high){
                merged[k++] = arr[i++];
            }else if(i > mid){
                merged[k++] = arr[j++];
            }else if(arr[i] <= arr[j]){
                merged[k++] = arr[i++];
            }else {
                merged[k++] = arr[j++];
            }
        }
        for(int i = 0; i < k; i++){
            arr[i + low] = merged[i];
        }
    }

    static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            sort(arr, low, mid, high);
        }
    }

    static int maxMin(int k, int[] arr) {
        int i = 0, min = Integer.MAX_VALUE, diff = 0, z = arr.length - k;
        mergeSort(arr, 0, arr.length - 1);
        while (i <= z){
            diff = arr[i + k - 1] - arr[i];
            if(diff < min){
                min = diff;
            }
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
        System.out.println(maxMin(10, a));
    }

}
