import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (true) {
            int L = sc.nextInt(), P = sc.nextInt(), V = sc.nextInt();
            if (L == 0 && P == 0 && V == 0) break;
            int res = L*(V/P);
            res += Math.min(L, V%P);
            i++;
            System.out.println("Case "+i+": "+res);
        }
    }
}