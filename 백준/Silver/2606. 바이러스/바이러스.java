import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ㅂㅏ이러스
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] graph = new int[1001][1001];
        boolean[] visited = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<p;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        queue.add(1);
        visited[1]= true;
        int cnt = 0;
        while (!queue.isEmpty()){
           int q = queue.poll();
           for(int i=1;i<=n;i++){
               if(graph[q][i]==1&&!visited[i]){
                   visited[i]= true;
                   queue.add(i);
                   cnt++;
               }
           }
        }
        System.out.println(cnt);
    }
}
