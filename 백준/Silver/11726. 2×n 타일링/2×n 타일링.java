
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[10001];
        dp[1] = 1; // 1
        dp[2] = 2; // 1 / 2
        int mod =10007;
        //dp[3] = 3; // 1 / 1,2 / 2,1
//        dp[4] = 5; // 1 / 1,1,2 / 2, 1,1 / 2,2 / 1,2,1
//        dp[5] = 8; // 1/ 1,1,1,2 / 2,1,1,1 / 1,2,1,1 / 1,1,2,1/ 2,2,1 / 1,2,2 /
//        dp[6] = 13 ; // 1/222/11112/21111/12111/11211/11121/2211/1122/1212/2121
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1]%mod + dp[i - 2]%mod;
        }
        System.out.println(dp[n]%mod);
    }
}
