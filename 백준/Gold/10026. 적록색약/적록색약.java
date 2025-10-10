
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

//23
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        String map[][] = new String[N][N];
        boolean visited[][] = new boolean[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }

        // 풀이
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        int cnt=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue; // 0인 애들 걸렀었음
                cnt ++;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});

                while(!q.isEmpty()){
                    int[] poll = q.poll();
                    int x = poll[0];
                    int y = poll[1];
                    for(int k=0;k<4;k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                        if(Objects.equals(map[nx][ny], map[x][y]) && !visited[nx][ny]){ // 기준과 색이 같으면
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }

        boolean visited_rg[][] = new boolean[N][N];
        int cnt_rg=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Objects.equals(map[i][j], "G")) {
                    map[i][j] = "R";
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited_rg[i][j]) continue; // 0인 애들 걸렀었음
                cnt_rg ++;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});

                while(!q.isEmpty()){
                    int[] poll = q.poll();
                    int x = poll[0];
                    int y = poll[1];
                    for(int k=0;k<4;k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                        if(Objects.equals(map[nx][ny], map[x][y]) && !visited_rg[nx][ny]){ // 기준과 색이 같으면
                            visited_rg[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        System.out.println(cnt+" "+cnt_rg);
    }
}
