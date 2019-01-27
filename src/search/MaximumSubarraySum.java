package search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum
 *
 * https://qr.ae/TUnJco
 */
public class MaximumSubarraySum {

    static long maximumSumBF(long[] a, long m) {
        long temp = 0;
        long[] prefix = new long[a.length];
        for(int i = 0; i < a.length; i++){
            temp = (a[i] % m + temp) % m;
            prefix[i] = temp;
        }
        long maxM = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i - 1; j >= 0; j--){
                maxM = Math.max(maxM, (prefix[i] - prefix[j] + m) % m);
            }
            maxM = Math.max(maxM, prefix[i]);
        }
        return maxM;
    }

    static long maximumSumTLE(long[] a, long m) {
        long curr = 0, maxM = 0;
        TreeSet<Long> prefix = new TreeSet<>();
        for(int i = 0; i < a.length; i++){
            curr = (a[i] % m + curr) % m;
            SortedSet<Long> set = prefix.tailSet(curr + 1);
            Iterator<Long> iter = set.iterator();
            while (iter.hasNext()){
                maxM = Math.max(maxM, (curr - iter.next() + m) % m);
            }
            maxM = Math.max(maxM, curr);
            prefix.add(curr);
        }
        return maxM;
    }

    /**
     * https://qr.ae/TUnJxO
     * @param a
     * @param m
     * @return
     */
    static long maximumSum(long[] a, long m) {
        long curr = 0, minM = Long.MAX_VALUE;
        long[] prefix = new long[a.length];
        int[] indices = new int[a.length];
        for(int i = 0; i < a.length; i++){
            curr = (curr + a[i] % m) % m;
            prefix[i] = curr;
            indices[i] = i + 1;
        }
        int temp;
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(prefix[i] > prefix[j]){
                    temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                    curr = prefix[i];
                    prefix[i] = prefix[j];
                    prefix[j] = curr;
                }
            }
        }
        for(int i = 0; i < a.length - 1; i++){
            if(indices[i] > indices[i + 1]){
                minM = Math.min(minM, prefix[i + 1] - prefix[i]);
            }
        }
        return m - minM;
    }


    public static void main(String[] args) {
        long[] arr = {3, 3, 9, 9, 5};
        System.out.println(maximumSum(arr, 7));
    }

}
