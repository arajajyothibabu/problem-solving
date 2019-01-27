package dynamic;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/candies
 */
public class Candies {

    static long candies(int n, int[] arr) {
        int[] dp = new int[n];
        long sum = 0;
        Arrays.fill(dp, 1);
        for(int i = 1;i < n; i++){
            if(arr[i] > arr[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
        }
        sum += dp[n - 1];
        for(int i = n - 2;i >= 0; i--){
            if(arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]){
                dp[i] = dp[i + 1] + 1;
            }
            sum += dp[i];
        }
        //common.Utils.printArray(dp);
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        System.out.println(candies(10, arr));
    }

}
