import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//34 56 (메모리초과) 25 40
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[][] graph = new int[1001][1001];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        int[] res = new int[n+1];

        for (int i = 0; i < n+1; i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
//            graph[u][v] = 1;
//            graph[v][u] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int p = queue.poll();
            for(int j=0;j<graph.get(p).size();j++){
                int node = graph.get(p).get(j);
                if(visited[node]) continue;
                //System.out.println("node: "+node+"p: "+p);
                queue.add(node);
                visited[node] = true;
                res[node] = p;
            }
        }

        for(int i=2;i<=n;i++){
            System.out.println(res[i]);
        }

    }
}
