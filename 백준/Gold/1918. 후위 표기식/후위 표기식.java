

import java.util.*;

//08
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>(); // 사칙연산
        String res = ""; // 결과 식
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        // 숫자 -> 바로 출력
        // 사칙연산 -> top 보다 우선순위 높거나, 비어있거나, top이 괄호 : 스택 push (낮으면 pop)
        // 위 조건이 아니면 계속 pop
        // () -> ) 있기 전까지 기존, ) 나오면 ( 까지 쭉 스택 pop

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Character.isDigit()으로 숫자인지 확인한 다음에 Character.getNumericValue()
           if(c=='+' || c=='-' || c=='*' || c=='/') { // 사칙연산
                while(!stack.isEmpty() && stack.peek()!='(' && map.get(stack.peek())>=map.get(c)) {
                    res+=stack.pop();
                }
                stack.push(c);
//                if(stack.isEmpty() || stack.peek()=='(' || map.get(stack.peek())<map.get(c) ) {
//                    stack.push(c);
//                }
            }else if(c=='(') {
                stack.push(c);
            }else if(c==')') {
                while(stack.peek()!='(') {
                    res+=stack.pop();
                }
                stack.pop();
            }else {
               res+=c;
           }
        }
        while (stack.size()!=0) {
            res+=stack.pop();
        }

        System.out.println(res);
    }
}
