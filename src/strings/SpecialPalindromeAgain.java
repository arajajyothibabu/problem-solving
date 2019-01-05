package strings;

import java.util.ArrayList;

public class SpecialPalindromeAgain {

    static class Pair {
        char c;
        int n;

        public Pair(char c, int n) {
            this.c = c;
            this.n = n;
        }

        @Override
        public String toString() {
            return this.c + " - " + this.n;
        }
    }

    static long substrCount(int n, String s) {
        long count = n;
        ArrayList<Pair> lettersWithCount = new ArrayList<>();
        char ch = s.charAt(0);
        int letterCount = 1;
        s = s + " "; //to collect last element seamlessly
        for(int i = 1; i <= n; i++){
            if(ch == s.charAt(i)){
                letterCount++;
            }else{
                count += letterCount * (letterCount + 1) / 2;
                lettersWithCount.add(new Pair(ch, letterCount));
                ch = s.charAt(i);
                letterCount = 1;
            }
        }
        Pair prev, next, current;
        for(int i = 1; i < lettersWithCount.size() - 1; i++){
            current = lettersWithCount.get(i);
            if(current.n == 1){
                prev = lettersWithCount.get(i - 1);
                next = lettersWithCount.get(i + 1);
                if(prev.c == next.c){
                    count += Math.min(prev.n, next.n);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "bbbabb";
        System.out.println(substrCount(6, s));
    }

}
