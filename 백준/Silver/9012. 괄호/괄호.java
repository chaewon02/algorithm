import java.util.Scanner;
import java.util.Stack;

// 49 59
// 괄호
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    stack.push(c);
                }else if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
