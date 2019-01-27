package common;

import java.util.List;

public class Utils {

    public static void swap(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void swap(Integer[] arr, Integer a, Integer b){
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static Integer[] reverse(Integer[] arr){
        Integer temp, len = arr.length;
        for(Integer i = 0; i < len / 2; i++){
            swap(arr, i, len - 1 - i);
        }
        return arr;
    }

    public static Integer arrayMinIndex(Integer[] arr) throws Exception {
        if(arr.length > 0){
            Integer temp = arr[0], index = 0;
            for(Integer i = 0; i < arr.length; i++){
                if(temp > arr[i]){
                    temp = arr[i];
                    index = i;
                }
            }
            return index;
        }else{
            throw new Exception("It's an empty Array");
        }
    }

    public static Integer arrayMaxIndex(Integer[] arr) throws Exception {
        if(arr.length > 0){
            Integer temp = arr[0], index = 0;
            for(Integer i = 0; i < arr.length; i++){
                if(temp < arr[i]){
                    temp = arr[i];
                    index = i;
                }
            }
            return index;
        }else{
            throw new Exception("It's an empty Array");
        }
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void printArray(char[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void printArray(long[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static <T> void printArray(List<T> arr){
        for(T i : arr){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println();
    }

}
