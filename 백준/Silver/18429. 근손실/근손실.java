
import java.util.Scanner;

public class Main {
    static int n ;
    static int k;
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        BackTracking(0,arr,check,500);
        System.out.println(cnt);
    }
    static void BackTracking(int idx, int[] arr,boolean[] check,int weight) {
        if (idx == n) {
            if (weight >= k) {
                cnt++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!check[i] && weight>=500){
                check[i]=true;
                BackTracking(idx+1,arr,check,weight-k+arr[i]);
                check[i]=false;
            }
        }
    }
}
