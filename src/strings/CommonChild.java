package strings;

/**
 * https://www.hackerrank.com/challenges/common-child
 */
public class CommonChild {

    static int commonChild(String s1, String s2) {
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        int len = s1c.length;
        int[][] matrix = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(s1c[i] == s2c[j]){
                    matrix[i][j] = matrix[Math.max(0, i - 1)][Math.max(0, j - 1)] + 1;
                }else{
                    matrix[i][j] = Math.max(matrix[Math.max(0, i - 1)][j], matrix[i][Math.max(0, j - 1)]);
                }
            }
        }
        return matrix[len - 1][len - 1];
    }

    public static void main(String[] args) {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";
        System.out.println(commonChild(s1, s2));
    }

}
