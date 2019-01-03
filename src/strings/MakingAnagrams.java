package strings;

import java.util.HashMap;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 */
public class MakingAnagrams {

    static HashMap<Character, Integer> makeMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 97; i <= 122; i++){
            map.put((char)i, 0);
        }
        int size = str.length();
        char c;
        for(int i = 0; i < size; i++){
            c = str.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    static int makeAnagramOlder(String a, String b) {
        HashMap<Character, Integer> mapA = makeMap(a);
        HashMap<Character, Integer> mapB = makeMap(b);
        int diff = 0;
        for(int i = 97; i <= 122; i++){
            diff += Math.abs(mapA.get((char)i) - mapB.get((char)i));
        }
        return diff;
    }

    static int makeAnagram(String a, String b) {
        int[] letters = new int[26];
        for(char c : a.toCharArray()){
            letters[c - 'a']++;
        }
        for(char c : b.toCharArray()){
            letters[c - 'a']--;
        }
        int diff = 0;
        for(int i : letters){
            diff += Math.abs(i);
        }
        return diff;
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym", b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagram(a, b));
    }

}
