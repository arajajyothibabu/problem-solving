package hashmaps.CountTriplets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    static long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        HashMap<Long, Long> map2 = new HashMap<Long, Long>();
        HashMap<Long, Long> map3 = new HashMap<Long, Long>();
        for (Long l : arr) {
            Long mul = l * r;
            if(map3.containsKey(l)){
                triplets += map3.get(l);
            }
            if(map2.containsKey(l)){
                if(map3.containsKey(mul)){
                    map3.put(mul, map3.get(mul) + map2.get(l));
                }else{
                    map3.put(mul, map2.get(l));
                }
            }
            if(map2.containsKey(mul)){
                map2.put(mul, map2.get(mul) + 1);
            }else{
                map2.put(mul, 1L);
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        Long arr[] = {1L, 2L, 1L, 2L, 4L};
        List<Long> list = new ArrayList<Long>(Arrays.asList(arr));
        System.out.println(countTriplets(list, 2));
    }

}
