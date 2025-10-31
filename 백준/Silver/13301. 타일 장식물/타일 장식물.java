
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(4);
            return;
        }else if(n==2){
            System.out.println(6);
            return;
        }
        if(n>40){
            long[] arr = new long[n+1];
            arr[1] = 1;
            arr[2] = 1;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.println(arr[n]*3 + arr[n-1]*2 + arr[n-2]*2 + arr[n-3]);
        }else{
            int[] arr = new int[n+1];
            arr[1] = 1;
            arr[2] = 1;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            } // 1 1 2 3 5
            System.out.println(arr[n]*3 + arr[n-1]*2 + arr[n-2]*2 + arr[n-3]);
        }
    }
}
