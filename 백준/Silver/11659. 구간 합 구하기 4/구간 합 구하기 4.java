
import java.io.IOException;
import java.util.Scanner;

//55 11
// 구간합
// 스트링빌더 -> 스트링 버퍼
// 누적합
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int mi = sc.nextInt();
            int mj = sc.nextInt();
            sb.append(sum[mj]-sum[mi-1]).append("\n");
        }
        System.out.println(sb);
    }
}
