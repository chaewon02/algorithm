

import java.util.*;

//56 33
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        ArrayList<Integer> nums = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0; // nums 인덱스
        for(int i = 0 ; i < n; i++){
            nums.add(scanner.nextInt()); // a~z에 대응되는 숫자
        }
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c) && c!='+' && c!='-' && c!='*' && c!='/'){
                map.put(c, nums.get(cnt));
                //System.out.printf("%c : %d", c, nums.get(cnt));
                cnt ++ ;
            }
        }
        Stack<Double> stack = new Stack<>();

        // 숫자 -> push
        // 사칙연산 -> top 두개 pop 해서, 연산
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='+'){
                Double a = stack.pop();
                Double b = stack.pop();
                Double res = a+b;
                stack.push(res);
            }else if(c=='-'){
                Double a = stack.pop();
                Double b = stack.pop();
                Double res = b - a;
                stack.push(res);
            }else if(c=='*'){
                Double a = stack.pop();
                Double b = stack.pop();
                Double res = a*b;
                stack.push(res);
            }else if(c=='/'){
                Double a = stack.pop();
                Double b = stack.pop();
                Double res = b / a;
                stack.push(res);
            } else{
                stack.push(Double.valueOf(map.get(c)));
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
