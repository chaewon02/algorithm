

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 08
public class Main {
    static int N;
    static int K;
    static ArrayList<Integer> coins = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        for(int i=0;i<N;i++){
            coins.add(sc.nextInt());
        }
        int[][] dp = new int[N+1][K+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=K;j++){
                dp[i][j] = -1;
            }
        }


//        for(int i=0;i<N;i++){
//            if(K>= coins.get(i)){
//                dp[i][j] =
//            }
//            for(int j=0;j<K;j++){
//                if(K>= coins.get(i)){
//                    dp[i][j] = Math.min(res, dp)
//                }
//            }
//        }
        int res = DP(0,K,dp);
        if(res == 100001){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }
    static int DP(int n,int k, int[][] dp){
        //System.out.println(n+" "+k);
        if(n==N){
            if(k==0){
                return 0;
            }else{
                return 100001;
            }
        }
        if(dp[n][k] != -1) return dp[n][k];
        int res = DP(n+1,k,dp) ;
        if(k>=coins.get(n)){
            res = Math.min(res, DP(n,k-coins.get(n),dp)+1);
        }
        dp[n][k] = res ;
        return res ;
    }
}
//3 7
//        2
//        3
//        6