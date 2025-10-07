import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = 300, B = 60, C = 10;
        int T = sc.nextInt();

        int a = T / A;
        int b = T % A / B;
        int c = T % A % B / C;
        if (T % A % B % C != 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b + " " + c);
        }
    }
}
