
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//10 54
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        int max = -1;
        int res = -1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = scanner.nextInt();
                if(max<map[i][j]) max = map[i][j];
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0,0,-1,1};

        for(int t=-1;t<=max;t++){
            int[][] new_map = map;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(new_map[i][j]<=t) new_map[i][j]=0;
                    //System.out.print(new_map[i][j]);
                }
                //System.out.println();
            }
            //System.out.println();
            boolean[][] visited = new boolean[n][n];
            int cnt=0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(new_map[i][j]==0||visited[i][j]) continue;
                    cnt++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[1];
                        int y = poll[0];
                        for(int k=0;k<4;k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx<0||ny<0||nx>=n||ny>=n) continue;
                            if(new_map[ny][nx]!=0 && !visited[ny][nx]){
                                queue.add(new int[]{ny,nx});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }
            if(res<cnt){
                res = cnt;
            }
        }
        System.out.println(res);


    }
}
