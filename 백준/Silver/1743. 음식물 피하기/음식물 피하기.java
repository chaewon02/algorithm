
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//59 49
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 행
        int m = scanner.nextInt(); // 열
        int k = scanner.nextInt(); // 쓰레기 개수
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 0;
            }
        }

        for(int i=0;i<k;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x-1][y-1] = 1;
        }


//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.print("\n");
//        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[n][m]; //false
        int max = -1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( visited[i][j] || map[i][j]==0) continue;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                int area = 1 ;
                queue.add(new int[]{i,j});

                while(!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    for (int kk = 0; kk < 4; kk++) {
                        int nx = x + dx[kk];
                        int ny = y + dy[kk];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (map[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            area ++;
                        }
                    }
                }
                if(max<area){
                    max = area;
                }
            }
        }

        System.out.println(max);
    }
}
