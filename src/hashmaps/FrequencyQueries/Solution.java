package hashmaps.FrequencyQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    static void incrementMapValue(HashMap<Integer, Integer> map, Integer key){
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }

    static void decrementMapValue(HashMap<Integer, Integer> map, Integer key){
        if(map.containsKey(key)){
            if(map.get(key) > 1){
                map.put(key, map.get(key) - 1);
            }else{
                map.remove(key);
            }
        }
    }

    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> solution = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Integer op, value, count;
        for(int[] query : queries){
            op = query[0];
            value = query[1];
            if(op.equals(1)){
                count = map.containsKey(value) ? map.get(value) + 1 : 1;
                incrementMapValue(map, value);
                incrementMapValue(counter, count);
                decrementMapValue(counter, count - 1);
            }else if(op.equals(2)){
                if(map.containsKey(value)){
                    count = map.get(value);
                    decrementMapValue(map, value);
                    decrementMapValue(counter, count);
                    if(count > 0){
                        incrementMapValue(counter, count - 1);
                    }
                }
            }else {
                solution.add(counter.containsKey(value) ? 1 : 0);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3};
        int arr2[] = {2, 3};
        int arr3[] = {3, 2};
        int arr4[] = {1, 4};
        int arr5[] = {1, 5};
        int arr6[] = {1, 5};
        int arr7[] = {1, 4};
        int arr8[] = {3, 2};
        int arr9[] = {2, 4};
        int arr10[] = {3, 2};
        List<int[]> list = new ArrayList<int[]>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        list.add(arr6);
        list.add(arr7);
        list.add(arr8);
        list.add(arr9);
        list.add(arr10);
        System.out.println(freqQuery(list));
    }

}