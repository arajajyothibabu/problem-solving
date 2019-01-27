package search;

import java.util.HashMap;

public class Pairs {

    static int pairs(int k, int[] arr) {
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, i);
        }
        for(int i : arr){
            if(map.containsKey(k + i)){
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        System.out.println(pairs(2, arr));
    }

}
