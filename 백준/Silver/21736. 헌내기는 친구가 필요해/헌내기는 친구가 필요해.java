import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13 34
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();


        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='X'){
                    map[i][j] = -1 ;
                }else if(str.charAt(j)=='P'){
                    map[i][j] = 1 ;
                }else if(str.charAt(j)=='I'){
                    map[i][j] = 2;
                    queue.add(new int[]{i,j}); // 시작점
                    visited[i][j] = true;
                }else{
                    // 0
                    map[i][j] = 0 ;
                }
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int cnt = 0;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(map[nx][ny]!=-1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    if (map[nx][ny] == 1) {
                        cnt++;
                    }
                }
            }
        }
        if(cnt==0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }
}
