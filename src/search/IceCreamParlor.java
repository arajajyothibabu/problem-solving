package search;

import java.util.HashMap;

public class IceCreamParlor {

    static void whatFlavorsOld(int[] cost, int money) {
        int first = 0;
        for(int i = 0; i < cost.length - 1;i++){
            if(cost[i] < money){
                int j = i + 1;
                while (j < cost.length){
                    if(cost[i] + cost[j] == money){
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                    j++;
                }
            }
        }
    }

    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int comp = 0;
        for(int i = 0; i < cost.length; i++){
            comp = money - cost[i];
            if(map.containsKey(comp)){
                System.out.println((map.get(comp) + 1) + " " +  (i + 1));
                return;
            }
            map.put(cost[i], i);
        }
    }

    public static void main(String[] args) {
        int[] cost = {2, 1, 3, 5, 6};
        whatFlavors(cost, 5);
    }

}
