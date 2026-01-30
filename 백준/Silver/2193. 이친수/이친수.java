

import java.util.Scanner;

//26 50
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        
        dp[1] = 1;//1
        if(n>=2){
            dp[2] = 1; //10
        }
//        dp[3] = 2; //100 101 +1
//        dp[4] = 3;//1000 1010 1001 +1
//        dp[5] = 5;// 10000 10001, 10101 10100, 100100 +2
//        dp[6] = 8;// 100000 100001 , 100010, 101010, 101000 101001 , 1001000 1001001 +3
        //dp[i] = dp[i-1] + dp[i-2]

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
