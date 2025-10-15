
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//47
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int map[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int max = Integer.MIN_VALUE;

        // 0인 경우 ,,
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) continue;
                Queue<int[]> queue = new LinkedList<>();
                boolean visited[][] = new boolean[N][M];
                queue.add(new int[]{i, j,0});
                int step = 0;
                int minStep = Integer.MAX_VALUE;

                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    step = poll[2];

                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (map[nx][ny] == 1) {
                            // step중 제일 작은 값
                            minStep = Math.min(minStep, step);
                            //break; // -> 여기서    break 하지말고 최솟값 구하기, 먼저만난다고 최솟값인건 아니다(큐니까  최솟값인줄)
                        }
                        if (map[nx][ny] == 0 && !visited[nx][ny]) {
                            queue.add(new int[]{nx, ny, step + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
                max = Math.max(max, minStep+1);
            }
        }
        System.out.println(max);
    }
}
