

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//14
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> coin = new ArrayList<>();
        int res = 0;
        for(int i =0;i<n;i++){
            coin.add(sc.nextInt());
        }

        for(int i=n-1;i>=0;i--){
            if(k!=0 && coin.get(i)<=k){
                res += k / coin.get(i);
                k = k % coin.get(i);
            }
        }

        System.out.println(res);
    }
}
