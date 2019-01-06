package greedy;

/**
 * https://www.hackerrank.com/challenges/luck-balance
 */
public class LuckBalance {

    static int luckBalance(int k, int[][] contests) { //Used counting sort
        int maxLuck = 0, imp = 0;
        int[] counter = new int[10001];
        for(int i = 0; i < contests.length; i++){
            if(contests[i][1] == 1){
                counter[contests[i][0]]++;
                imp++;
            }
            maxLuck += contests[i][0];
        }
        int haveToWin = imp - k;
        if(haveToWin > 0){
            for(int i = 1; i < counter.length;){
                if(haveToWin > 0 && counter[i] > 0){
                    while (counter[i] > 0 && haveToWin > 0){
                        haveToWin--;
                        maxLuck -= 2 * i;
                        counter[i]--;
                    }
                    if(haveToWin > 0){
                        i++;
                    }
                }else{
                    i++;
                }
            }
        }
        return maxLuck;
    }

}
