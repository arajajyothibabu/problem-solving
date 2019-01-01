package sorting;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications
 *
 */
public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        if(expenditure.length != 0 && d < expenditure.length){
            int counter[] = new int[201];
            for(int i = 0; i < d; i++){
                counter[expenditure[i]]++;
            }
            int i1 = (int)Math.floor((float)(d - 1) / 2);
            int i2 = (int)Math.ceil((float)(d - 1) / 2);
            int m1 = 0, m2 = 0;
            for(int i = d; i < expenditure.length; i++){
                for(int j = 0, k = 0; k <= i1; k += counter[j], j++){
                    m1 = j;
                }
                for(int j = 0, k = 0; k <= i2; k += counter[j], j++){
                    m2 = j;
                }
                float m = (float)(m1 + m2) / 2;
                if(m * 2 <= expenditure[i]){
                    notifications++;
                }
                counter[expenditure[i - d]]--;
                counter[expenditure[i]]++;
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
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(activityNotifications(arr, 3));
    }

}
