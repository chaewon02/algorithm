
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//연속합
// 47 09 37
public class Main {
    public static void main(String[] args) throws IOException {
  //10 6 9 10 15 -20 -8 13 12
        // -4 -1 0 5 11 -!
        // 12 33 31
        // -> 메모리 초과
        // 누적합 한개 -> 누적합값이랑 현재 값 중 큰 것
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        int max =  dp[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
