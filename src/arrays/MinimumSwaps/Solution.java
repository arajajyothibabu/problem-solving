package arrays.MinimumSwaps;

public class Solution {

    static int indexOfMin(int[] arr, int startIndex){
        int min = Integer.MAX_VALUE, minIndex = startIndex;
        if(arr.length > 0 && startIndex > -1 && startIndex < arr.length){
            for(int i = startIndex; i < arr.length; i++){
                if(arr[i] < min){
                    min = arr[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for(int i = 0; i < arr.length; i++){
            int minIndex = indexOfMin(arr, i);
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 4, 6, 7};
        System.out.println(minimumSwaps(arr));
    }

}
