
import java.io.IOException;
import java.util.*;

// 441
public class Main {
  
    public static void main(String[] args) throws IOException {
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        Queue<int[]> q = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int map[][] = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) q.offer(new int[]{i,j,0});
            }
        }

        // 풀이
        int days = 0 ;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            days = temp[2];

            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(map[nx][ny]==0) {
                    map[nx][ny] = 1;
                    q.offer(new int[]{nx,ny,days+1});
                }
            }
        }

        int tomato = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){ // 익지 않은 토마토가 있으면
                    tomato = 0;
                }
            }
        }
        if(tomato==1){
            System.out.println(days);
        }else {
            System.out.println(-1);
        }
    }
}
