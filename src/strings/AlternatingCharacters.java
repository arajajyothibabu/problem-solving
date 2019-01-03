package strings;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int size = s.length(), count = 0;
        for(int i = 1; i < size; i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                count++;
            }
        }
        return count;
    }

}
