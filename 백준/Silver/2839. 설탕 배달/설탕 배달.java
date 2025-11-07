
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        while (n>=0) {
            if (n % 5 == 0) {
                sum += n/5;
                break;
            }else {
                n = n - 3;
                sum += 1;
            }
            if(n<0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sum);
    }
}
