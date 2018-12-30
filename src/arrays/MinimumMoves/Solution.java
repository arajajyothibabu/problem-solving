package arrays.MinimumMoves;

public class Solution {

    static int minimumMoves(int[] arr) {
        int highestSeqStrength = 1, seqStrength = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] <= arr[i]){
                seqStrength++;
            }else{
                seqStrength = 1;
            }
            if(seqStrength > highestSeqStrength){
                highestSeqStrength = seqStrength;
            }
        }
        return arr.length - highestSeqStrength;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 4, 6, 7};
        System.out.println(minimumMoves(arr));
    }

}

