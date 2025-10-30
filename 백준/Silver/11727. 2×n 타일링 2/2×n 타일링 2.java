import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int res = 0;

        // 세로로 긴 직사각형 1개 (1) / 가로로 긴 직사각형, 가로세로2칸 정사각형 2개 (2)
        // 가로로만 생각해도 됨! (세로 1칸이라고 가정) 그러니까 1칸 짜리 1개, 2칸 짜리 2개로 생각한다.
        if (n > 1) {
            dp[0] = 1; // 한 칸
            dp[1] = 1 + (1 * 2);
            for (int i = 2; i < n; i++) { // 두 칸
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
            }
            res = dp[n - 1];
        } else if (n == 1) {
            // 2*1(세로로 긴 직사각형 1개)
            res = 1;
        }
        System.out.println(res);
    }
}