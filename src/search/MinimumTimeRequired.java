package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.hackerrank.com/challenges/minimum-time-required
 */
public class MinimumTimeRequired {

    static long minTimeBF(long[] machines, long goal) {
        long days = 1, prod = 0;
        while(prod < goal){
            for(long m : machines){
                prod += days / m;
            }
            if(prod < goal){
                days++;
                prod = 0;
            }
        }
        return days;
    }

    static long minOf(long[] arr){
        long min = Long.MAX_VALUE;
        for(long i : arr){
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    static long maxOf(long[] arr){
        long max = Long.MIN_VALUE;
        for(long i : arr){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    static long minTime(long[] machines, long goal) {
        long days = 1, prod = 0;
        long minDays = minOf(machines);
        long maxDays = maxOf(machines);

        return days;
    }

    public static void main(String[] args) {
        long[] machines = {4, 5, 6};
        System.out.println(minTime(machines, 12));
    }

}
