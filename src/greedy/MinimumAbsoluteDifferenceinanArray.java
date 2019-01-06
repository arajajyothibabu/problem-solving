package greedy;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
 */
public class MinimumAbsoluteDifferenceinanArray {

    static int minimumAbsoluteDifferenceBF(int[] arr) { //Bruteforce
        int min = Integer.MAX_VALUE, temp;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j){
                    temp = Math.abs(arr[i] - arr[j]);
                    if(min > temp){
                        min = temp;
                    }
                }
            }
        }
        return min;
    }

    static int partition(int[] arr, int low, int high){
        int pivotEl = arr[high];
        int lowerElIndex = low, temp;
        for(int i = low; i < high; i++){
            if(arr[i] <= pivotEl){
                temp = arr[i];
                arr[i] = arr[lowerElIndex];
                arr[lowerElIndex] = temp;
                lowerElIndex++;
            }
        }
        arr[high] = arr[lowerElIndex];
        arr[lowerElIndex] = pivotEl;
        return lowerElIndex;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int minimumAbsoluteDifference(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int minDiff = Math.abs(arr[0] - arr[1]), diff;
        for(int i = 1; i < arr.length - 1; i++){
            diff = Math.abs(arr[i] - arr[i + 1]);
            if(minDiff > diff){
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] a = {2, 6, 1, 7, 3};
        System.out.println(minimumAbsoluteDifference(a));
    }

}
