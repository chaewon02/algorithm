import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int map[][] = new int[N][M];
        boolean visited[][] = new boolean[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // 풀이
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        int dist[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = 0;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j] || map[i][j]==0) continue;
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});
                dist[i][j]++;

                while (!q.isEmpty()){
                    int[] temp = q.poll();
                    int x = temp[0];
                    int y = temp[1];
                    for(int k=0;k<4;k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx<0||ny<0||nx>=N||ny>=M) continue;
                        if(map[nx][ny]==0 || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                        dist[nx][ny] = dist[x][y]+1;
                    }
                }
            }
        }
        System.out.println(dist[N-1][M-1]);

    }
}
