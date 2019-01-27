package dynamic;

import java.util.ArrayList;

/**
 * https://www.hackerrank.com/challenges/max-array-sum
 */
public class MaxArraySum {

    static int maxSubsetSumL(int[] arr) {
        ArrayList<Integer> tracker = new ArrayList<>();
        tracker.add(arr[0]);
        if(arr.length > 1){
            tracker.add(Math.max(arr[0], arr[1]));
        }
        for(int i = 2; i < arr.length; i++){
            tracker.add(Math.max(Math.max(tracker.get(i - 2) + arr[i], arr[i]), tracker.get(i - 1)));
        }
        return tracker.get(arr.length - 1);
    }

    static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        int[] a = {3, 5, -7, 8, 10};
        System.out.println(maxSubsetSum(a));
    }

}
