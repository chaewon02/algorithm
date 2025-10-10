
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 38
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // 풀이
        int min = 1;
        int visted[] = new int[100001];
        for (int i = 0; i < N; i++) {}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        if(N==K){
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int sum = temp[0];
            int cnt = temp[1];
            if(sum >=0 && sum <=100000 ){
                if ( visted[sum]==1 ) continue;
                if (sum == K) {
                    min = cnt;
                    break;
                }
                //System.out.println(sum+" "+cnt+" "+visted[sum]);
                visted[sum]=1;
                queue.add(new int[]{sum+1, cnt+1});
                queue.add(new int[]{sum-1, cnt+1});
                queue.add(new int[]{sum*2, cnt+1});
            }
        }
        System.out.println(min);
    }
}
