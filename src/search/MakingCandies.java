package search;

/**
 * https://www.hackerrank.com/challenges/making-candies
 */
public class MakingCandies {

    static long minimumPasses(long m, long w, long p, long n) {
        if(p >= n){
            return (long)Math.ceil((double)n / (double)(m * w));
        }
        if(m >= n || w >= n || (double)m * w > n){
            return 1;
        }
        long passes = 0, candies = 0, unitsCanBuy = 0, half = 0;
        int i = 0;
        while(candies < n){
            passes++;
            candies += (double) m * w;
            unitsCanBuy = candies / p;
            /*System.out.println(passes);
            System.out.println(m);
            System.out.println(w);
            System.out.println(candies);
            System.out.println(unitsCanBuy);
            System.out.println();*/
            if(candies < n / 2 && unitsCanBuy > 0){
                if(unitsCanBuy % 2 == 1){
                    if(m < w){
                        m++;
                    }else{
                        w++;
                    }
                }
                half = unitsCanBuy / 2;
                w += half;
                m += half;
                if((double)m * w < n){
                    candies -= unitsCanBuy * p;
                }
            }
        }
        return passes;
    }

    public static void main(String[] args) {
        System.out.println(minimumPasses(1, 1, 6, 4));
    }

}
