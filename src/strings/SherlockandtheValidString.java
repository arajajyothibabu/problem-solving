package strings;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class SherlockandtheValidString {

    static String isValid(String s) {
        String YES = "YES", NO = "NO";
        boolean removedOnce = false;
        int[] letters = new int[26];
        for(char c : s.toCharArray()){
            letters[c - 'a']++;
        }
        int commonCount = 0;
        //common.Utils.printArray(letters);
        for(int c : letters){
            if(c != 0){
                if(commonCount == 0){
                    commonCount = c;
                }else if(commonCount != c){
                    if(Math.abs(commonCount - c) > 0){ //All extra occurrences of single char is taken as single deletion/excuse
                        if(removedOnce){
                            return NO;
                        }
                        removedOnce = true;
                    }
                }
            }
        }
        return YES;
    }

    public static void main(String[] args) {
        String s = "abcdefghhgfedecba";
        System.out.println(isValid(s));
    }

}
