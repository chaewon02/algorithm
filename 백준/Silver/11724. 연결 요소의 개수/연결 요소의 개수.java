
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//10 07
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 정점 개수
        int m = scanner.nextInt(); // 간선 개수
        int[][] graph = new int[10001][10001];
        boolean[] visited = new boolean[10001]; // false

        for(int i=0;i<m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()){
                int q = queue.poll();
                //System.out.println(q);
                for(int j=1;j<=n;j++){
                    if(graph[q][j]==1 && !visited[j]){
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            cnt++;
            //System.out.println("cnt--");
        }
        System.out.println(cnt);

    }
}
