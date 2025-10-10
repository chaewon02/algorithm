
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//00 18 23
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int I = sc.nextInt();
            int cur_x=0, cur_y = 0, target_x=0, target_y=0;
            cur_x = sc.nextInt();
            cur_y = sc.nextInt();
            target_x = sc.nextInt();
            target_y = sc.nextInt();
            int map[][] = new int[I][I];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{cur_x, cur_y,0});

            int[] dx = {2,2,-2,-2,1,1,-1,-1};
            int[] dy = {-1,1,-1,1,-2,2,-2,2};

            map[cur_x][cur_y] = 1;
            int cnt = 0;

            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                cnt = poll[2];

                if(x==target_x && y==target_y){
                    break;
                }
                for(int k = 0; k < 8; k++) {
                    int nx = x + dx[k] ;
                    int ny = y + dy[k] ;
                    if(nx < 0 || ny<0||nx>=I||ny>=I) continue;
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new int[]{nx, ny,cnt+1});
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
