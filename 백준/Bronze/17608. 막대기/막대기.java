import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        int r = arr[N-1]; //갱신
        for (int i = N-2; i >= 0; i--) {
            if(arr[i]>r){
                cnt++;
                r=arr[i];
            }
        }

        System.out.println(cnt+1);

    }
}
