package common;

public class Printer {

    public static void printArray(Integer[] arr){
        System.out.println();
        for(Integer i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
