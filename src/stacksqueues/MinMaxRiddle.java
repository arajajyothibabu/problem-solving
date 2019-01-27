package stacksqueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/min-max-riddle
 *
 * A few hints for people who are banging their heads on the wall trying to pass all test cases:
 *
 * 1) O(N) solution is possible using stacks; avoid DP for this problem
 *
 * 2) Think about how to identify the largest window a number is the minimum for (e.g. for the sequence 11 2 3 14 5 2 11 12 we would make a map of number -> window_size as max_window = {11: 2, 2: 8, 3: 3, 14: 1, 5: 2, 12: 1}) - this can be done using stacks in O(n)
 *
 * 3) Invert the max_window hashmap breaking ties by taking the maximum value to store a mapping of windowsize -> maximum_value (continuing with example above inverted_windows = {1: 14, 8:2, 3:3, 2:11}
 *
 * 4) starting from w=len(arr) iterate down to a window size of 1, looking up the corresponding values in inverted_windows and fill missing values with the previous largest window value (continuing with the example result = [2, 2, 2, 2, 2, 3, 11, 14] )
 *
 * 5) Return the result in reverse order (return [14, 11, 3, 2, 2, 2, 2, 2])
 *
 * *********************************
 * This problem is a two-way, least price stock problem.
 *
 * The canonical stock span problem can be formulated as:
 *
 * Consider a stock price sampled on the kth day, denoted price[k], What is the largest i, where i < k, such that for all i <= j < k, price[j] <= price[k]? In other words, given a kth day stock price price[k], for how many consecutive previous days has price[k] reigned as the greatest?
 *
 * For this problem, we need to solve two instances of the stock span problem, one going back in time and one going "forward" in time; furthermore, rather than considering how long price[k] has been the greatest for, we need to consider how long price[k] has been the smallest for. I shall denote them problem 1 and problem 2:
 *
 * Problem 1. Consider a stock price sampled on the kth day, denoted price[k]. What is the largest i, where i < k, such that for all i <= j < k, price[j] >= price[k]? In other words, given a kth day stock price price[k], for how many previous consecutive days has price[k] been the lowest?
 *
 * Problem 2. Consider a stock price sampled on the kth day, denoted price[k], What is the largest m, where k < m, such that for all k <= l < m, price[k] <= price[m]? In other words, given a kth day stock price price[k], for how many next consecutive days will price[k] have been the lowest?
 *
 * Combine the results from problem 1 and 2 to determine the largest window that a given number is a minimum for. Be careful with counting when you combine the results.
 *
 */
public class MinMaxRiddle {

    static long[] riddleDP(long[] arr) {
        long[][] dp = new long[arr.length][];
        long[] sol = new long[arr.length];
        dp[0] = arr;
        long max = 0;
        for(long l : arr){
            if(l > max){
                max = l;
            }
        }
        sol[0] = max;
        for(int i = 1; i < arr.length; i++){
            max = 0;
            dp[i] = new long[arr.length - 1];
            for(int j = 0; j < arr.length - i; j++ ){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
            sol[i] = max;
        }
        return sol;
    }

    static long[] riddle(long[] arr) {
        long[] sol = new long[arr.length];
        Stack<Integer> stack = new Stack<>();
        long[] span = new long[arr.length];
        stack.push(0);
        for(int i = 1; i < arr.length; i++){
            while (!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            span[i] = stack.empty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }
        //common.Utils.printArray(span);
        stack.clear();
        stack.push(arr.length - 1);
        for(int j = arr.length - 2; j > -1; j--){
            while (!stack.empty() && arr[stack.peek()] >= arr[j]){
                stack.pop();
            }
            span[j] += stack.empty() ? arr.length - j - 1 : stack.peek() - j -1;
            stack.push(j);
        }
        //common.Utils.printArray(span);

        // fill results
        for (int i = 0; i < arr.length; i++) {
            sol[(int) span[i]] = Math.max(sol[(int) span[i]], arr[i]);
        }

        // fill the gaps
        for (int i = arr.length - 2; i >= 0; i--) {
            sol[i] = Math.max(sol[i], sol[i + 1]);
        }
        return sol;
    }

    public static void main(String[] args) {
        long[] a = {11, 2, 3, 14, 5, 2, 11, 12};
        common.Utils.printArray(riddle(a));
    }

}
