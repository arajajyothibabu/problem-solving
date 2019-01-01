package sorting.MarkandToys;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    static int maximumToys(int[] prices, int k) {
        ArrayList<Integer> affordable = new ArrayList<>();
        for(int price : prices){
            if(price < k){
                affordable.add(price);
            }
        }
        int max = 0, temp, sum = 0;
        Collections.sort(affordable); //because you vexed with sorting!
        for(Integer price : affordable){
            sum += price;
            if(sum < k){
                max++;
            }else{
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println(maximumToys(arr, 50));
    }

}
