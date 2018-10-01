package common;

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

}
