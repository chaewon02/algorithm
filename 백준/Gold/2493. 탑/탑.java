
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑 (골드)
// 시간초과 35분 / 1시간
// 스택이 인덱스와, 높이 기억하는게 포인트
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 탑 높이 배열
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(val <= stack.peek()[1]){
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }
            stack.push(new int[]{i+1,val});

        }
        System.out.println(sb);

    }
}
