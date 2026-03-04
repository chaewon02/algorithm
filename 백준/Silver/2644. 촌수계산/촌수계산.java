
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 43 43
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p = sc.nextInt();
        int[][] graph = new int[1001][1001];
        boolean[] visited = new boolean[1001];
        for(int i=0;i<p;i++){
            int u= sc.nextInt();
            int v=sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.add(new int[]{x,count});
        visited[x] = true;
        int res = -1;
        
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int q = poll[0];
            int cnt = poll[1];
        
            if(q==y){
                res = cnt;
                break;
            }
            for(int j=1;j<=n;j++){
                if(graph[q][j]==1&&!visited[j]){
                    visited[j] = true;
                    queue.add(new int[]{j,cnt+1});
                    //map[q] ++;
                }
            }
        }
        System.out.println(res);


    }
}
