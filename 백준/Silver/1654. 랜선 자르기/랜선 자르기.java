
import java.util.Scanner;

//
public class Main {
    static long res = Integer.MAX_VALUE;
    static long max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
        }
//        if(arr.length==1){
//            System.out.println(arr[0]);
//            return;
//        }

        System.out.println(BinarySearch(arr, n));

    }
    private static long BinarySearch(long[] arr, int target) {
        long low = 1; // 길이라 1로 시작
        long high = max;
        long mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long total_cnt = 0; // 계속 갱신되어야 함,,
            for (int j = 0; j < arr.length; j++) {
                total_cnt += arr[j] / mid;
            }
            if (total_cnt >= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
