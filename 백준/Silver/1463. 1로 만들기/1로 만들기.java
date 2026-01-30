
import java.util.Scanner;

import static java.lang.Math.min;

// 1시간
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp_memo = new int[10000001];
        // 인덱스를 n으로, 내용을 count
        for (int i = 2; i <= n; i++) {
            dp_memo[i] = dp_memo[i-1]+1;
            if (i%2 == 0) dp_memo[i] = min(dp_memo[i],dp_memo[i/2]+1);
            if (i%3 == 0) dp_memo[i] = min(dp_memo[i],dp_memo[i/3]+1);
        }
        System.out.println(dp_memo[n]);
    }
}
