
import java.util.ArrayList;
import java.util.Scanner;

//제로
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int n = scanner.nextInt();
            if (n == 0) {
                stack.remove(stack.size() - 1);
            }else{
                stack.add(n);
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
