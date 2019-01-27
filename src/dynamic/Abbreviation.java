package dynamic;

/**
 * https://www.hackerrank.com/challenges/abbr
 */
public class Abbreviation {

    /**
     * What we need to solve is, regardless of the case,
     * if b is a subsequence of a with the constraint that a can only discard lower case characters.
     * Therefore, if we want to know if b[0, i] is an abbreviation of a[0, j], we have two cases to consider:
     *
     * *
     * a[j] is a lower case character.
     *
     * if uppercase(a[j]) == b[i],
     *  either b[0, i - 1] is an abbreviation of a[0, j - 1] or b[0, i - 1] is an abbreviation of a[0, j],
     *      b[0, i] is an abbreviation of a[0, j].
     *
     * else if
     *  b[0, i] is an abbreviation of a[0, j -1],
     *      b[0, i] is an abbreviation of a[0, j].
     *
     * else,
     *      b[0, i] cannot be an abbreviation of a[0, j].
     *
     * *
     * a[j] is a upper case character.
     *
     * if a[j] == b[i] and b[0, i - 1] is an abbreviation of a[0, j - 1],
     *      b[0, i] is an abbreviation of a[0, j].
     *
     * else
     *      b[0, i] cannot be an abbreviation of a[0, j].
     *
     * @param a
     * @param b
     * @return
     */
    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (Character.isLowerCase(a.charAt(j - 1))) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
                if (ca >= 'A' && ca <= 'Z') {
                    if (ca == cb) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }else {
                    ca = Character.toUpperCase(ca);
                    if (ca == cb){
                        dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                    }
                    else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[b.length()][a.length()] ? "YES" : "NO";
    }

    static String abbreviationRec(String a, String b) {
        String YES = "YES", NO = "NO";
        if(b.length() == 0 && a.length() == 0){
            return YES;
        }else if(a.length() == 0){
            return NO;
        }else if(b.length() == 0){
            return a.toLowerCase().equals(a) ? YES : NO;
        }else {
            if(a.charAt(0) == b.charAt(0) || a.charAt(0) - 32 == b.charAt(0)){
                return abbreviationRec(a.substring(1), b.substring(1));
            }else{
                if(a.substring(0, 1).toLowerCase().equals(a.substring(0, 1))){
                    return abbreviationRec(a.substring(1), b);
                }else{
                    return NO;
                }
            }
        }
    }

    public static void main(String[] args) {
        String a = "aaAA", b = "AA";
        System.out.println(abbreviation(a, b));
    }

}
