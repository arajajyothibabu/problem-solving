package sorting.BubbleSort;

public class Solution {

    static void countSwaps(int[] a) {
        int temp, swaps = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length - 1; j++){
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        countSwaps(arr);
    }


}
