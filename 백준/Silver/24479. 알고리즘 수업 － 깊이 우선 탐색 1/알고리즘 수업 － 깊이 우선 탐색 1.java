import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1h
public class Main{
    static int n ;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //int[][] graph = new int[n+1][n+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n+1];

        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(visited,graph,start); // 1 1
        for(int i=1;i<=n;i++){
            System.out.println(visited[i]);
        }
    }
    static void dfs(int[] visited,ArrayList<ArrayList<Integer>> graph,int p ){
        visited[p] = ++cnt;
        graph.get(p).sort(null);
        for(int j : graph.get(p)){ //graph[p][j]==1
            if(visited[j]==0){
                //cnt++;
                dfs(visited,graph,j);
            }
        }
    }
}
