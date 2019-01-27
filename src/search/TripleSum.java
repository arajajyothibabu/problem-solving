package search;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/triple-sum
 */

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        SortedSet<Integer> aS = new TreeSet<>(), bS = new TreeSet<>(), cS = new TreeSet<>();
        for (int i : a) {
            aS.add(i);
        }
        for(int i : b){
            bS.add(i);
        }
        for(int i : c){
            cS.add(i);
        }
        ArrayList<Integer> aA = new ArrayList<>(aS);
        ArrayList<Integer> cA = new ArrayList<>(cS);
        int aI = 0, cI = 0, aSize = aS.size(), cSize = cS.size();
        long total = 0;
        for(Integer i : bS){
            while(aI < aSize && aA.get(aI) <= i){
                aI++;
            }
            while(cI < cSize && cA.get(cI) <= i){
                cI++;
            }
            total += aI * cI;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {5, 7, 9};
        int[] c = {7, 9, 11, 13};
        System.out.println(triplets(a, b, c));
    }

}
