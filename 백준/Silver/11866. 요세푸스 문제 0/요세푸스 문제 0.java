import java.util.Scanner;

// 1시간
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        int i = K - 1;
        int cnt = 0;
        int k = K;
        int res[] = new int[N];

        while (true) {
            if (cnt == N) {
                break;
            }
            if (arr[i] == 0) {
                i++;
                if (i >= N) {
                    i = 0;
                }
                continue;
            }
            if (k == K) {
                res[cnt] = arr[i];
                arr[i] = 0;
                cnt++;
                k = 0;
            }
            k++;
            i++;
            if (i >= N) {
                i = 0;
            }
        }
        System.out.print("<");
        for (int j = 0; j < res.length; j++) {
            if (j == res.length - 1) {
                System.out.print(res[j] + ">");
            } else {
                System.out.print(res[j] + ", ");
            }
        }
    }
}
