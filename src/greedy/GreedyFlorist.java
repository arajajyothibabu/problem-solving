package greedy;

/**
 * https://www.hackerrank.com/challenges/greedy-florist
 */
public class GreedyFlorist {

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

    static int getMinimumCost(int k, int[] c) {
        mergeSort(c, 0, c.length - 1);
        int cost = c[c.length - 1];
        int currentLap = 0;
        int highestMod = c.length % k;
        for(int i = c.length - 2; i >= 0; i--){
            if((i + 1) % k == highestMod){
                currentLap++;
            }
            cost += (currentLap + 1) * c[i];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] a = {9, 7, 1, 5, 3};
        int k = 3;
        System.out.println(getMinimumCost(3, a));
    }

}
