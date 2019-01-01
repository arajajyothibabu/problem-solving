package sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications
 *
 */
public class FraudulentActivityNotifications {

    /*static int[] insertionSort(int[] inputArr){
        int temp;
        int[] arr = inputArr;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }*/

    static void insertionSort(int[] arr){
        int temp;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    static float median(ArrayList<Integer> arr){
        int size = arr.size(), half = size / 2;
        if(size % 2 == 0){
            if(size > 1){
                return (arr.get(half) + arr.get(half + 1)) / 2;
            }
            return 0;
        }else{
            return arr.get(half);
        }
    }

    static float median(int[] arr){
        int size = arr.length, half = size / 2;
        if(size % 2 == 0){
            if(size > 1){
                return (arr[half] + arr[half + 1]) / 2;
            }
            return 0;
        }else{
            return arr[half];
        }
    }

    /*static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        if(expenditure.length != 0 && d < expenditure.length){
            ArrayList<Integer> trailingDays = new ArrayList<>();
            for(int i = 0; i < expenditure.length; i++){
                if(i >= d){
                    Collections.sort(trailingDays);
                    if(median(trailingDays) * 2 <= expenditure[i]){
                        notifications++;
                    }
                    trailingDays.remove(new Integer(expenditure[i - d]));
                }
                trailingDays.add(expenditure[i]);
            }
        }
        return notifications;
    }*/

    static void insertionHelper(int[] arr, int toRemove, int toInsert){
        if(toRemove == toInsert){
            return;
        }
        boolean inserted = false;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == toRemove){
                arr[i] = arr[i+1];
                arr[i+1] = toRemove;
            }
            if(arr[i] > toInsert){
                arr[i+1] = arr[i];
                arr[i] = toInsert;
                inserted = true;
                break;
            }
        }
        if(!inserted){
            arr[arr.length - 1] = toInsert;
        }
    }

    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        if(expenditure.length != 0 && d < expenditure.length){
            int[] trailingDays = new int[d];
            for(int i = 0; i < d; i++){
                trailingDays[i] = expenditure[i];
            }
            insertionSort(trailingDays);
            for(int i = d; i < expenditure.length; i++){
                if(median(trailingDays) * 2 <= expenditure[i]){
                    notifications++;
                }
                insertionHelper(trailingDays, expenditure[i - d], expenditure[i]);
            }
        }
        return notifications;
    }

    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        System.out.println(activityNotifications(arr, 5));
    }

}
