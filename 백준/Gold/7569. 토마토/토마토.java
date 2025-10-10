
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//50
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); //열
        int N = scanner.nextInt(); //행
        int H = scanner.nextInt();
        int map[][][] = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int h=0;h<H;h++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = scanner.nextInt();
                    if(map[h][i][j] == 1){
                        queue.add(new int[]{h,i,j,0});
                    }
                }
            }
        }

        int[] dx = {-1,1,0,0,0,0};
        int[] dy = {0,0,-1,1,0,0};
        int[] dz = {0,0,0,0,1,-1}; // 위 아래
        int days = 0;

        while(!queue.isEmpty()){
            // 토마토 1개 위치, 익은 날짜
            int[] poll = queue.poll();
            int z = poll[0];
            int x = poll[1];
            int y = poll[2];
            days = poll[3];
            //System.out.println(z + " " + x + " " + y + " " + days);

            for(int i = 0;i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>=N || ny>=M || nz>=H) continue;
                if(map[nz][nx][ny] == 0){
                    map[nz][nx][ny] = 1;
                    queue.add(new int[]{nz,nx,ny,days+1});
                }
            }
        }

        int tomato = 1;
        for(int h=0;h<H;h++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[h][i][j] == 0){
                        tomato = -1;
                    }
                }
            }
        }

        if(tomato == -1){
            System.out.println(tomato);
        }else{
            System.out.println(days);
        }

    }
}
