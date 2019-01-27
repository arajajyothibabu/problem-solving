package greedy;

/**
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge
 */
public class ReverseShuffleMerge {

    static int minFromArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                return i;
            }
        }
        return 0;
    }

    static String reverseShuffleMerge(String s) {
        String a = "";
        int[] freqS = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            freqS[c - 'a']++;
        }
        int sSize = chars.length, index = 0, inc = 0;
        char[] aChars = new char[sSize / 2];
        int[] freqA = new int[26];
        for(int i = sSize - 1; i >= 0; i--){
            index = chars[i] - 'a';
            if(freqS[index] > freqA[index]){
                if(minFromArray(freqS) == index){
                    aChars[inc++] = chars[i];
                }
                freqS[index]--;
                freqA[index]++;
            }else{
                if(inc < sSize / 2){
                    aChars[inc++] = chars[i];
                }
            }
        }
        return String.valueOf(aChars);
    }

    public static void main(String[] args) {
        String s = "abcdefgabcdefg";
        System.out.println(reverseShuffleMerge(s));
    }

}
