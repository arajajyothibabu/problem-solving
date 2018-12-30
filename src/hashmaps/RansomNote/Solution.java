package hashmaps.RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static HashMap<String, Integer> arrayToMap(String[] arr) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String str : arr){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
        }
        return map;
    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> noteMap = arrayToMap(note);
        HashMap<String, Integer> magazineMap = arrayToMap(magazine);
        for(Map.Entry<String, Integer> entry : noteMap.entrySet()){
            if(!magazineMap.containsKey(entry.getKey()) || entry.getValue() > magazineMap.get(entry.getKey())){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        String magazine[] = "two times three is not four".split(" ");
        String note[] = "two times two is four".split(" ");
        checkMagazine(magazine, note);
    }

}
