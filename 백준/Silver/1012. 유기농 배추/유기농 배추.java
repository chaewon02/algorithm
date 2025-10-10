import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//36
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // 가로
            int M = scanner.nextInt(); //세ㅔ로
            int K = scanner.nextInt(); // 위치개수
            int x[] = new int[K];
            int y[] = new int[K];
            int map[][] = new int[N][M];
            boolean visited[][] =new boolean[N][M];
            Queue<int[]> queue = new LinkedList<>();

            for (int j = 0; j < K; j++) {
                x[j] = scanner.nextInt();
                y[j] = scanner.nextInt();
                map[x[j]][y[j]] = 1;
            }

            // 상하좌우 네 방향
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int cnt = 0;

            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(visited[n][m] || map[n][m]==0) continue;
                    cnt++;
                    queue.offer(new int[]{n,m});
                    visited[n][m] = true;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int xx = poll[0];
                        int yy = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = xx + dx[k];
                            int ny = yy + dy[k];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] == 1 && !visited[nx][ny]){
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
