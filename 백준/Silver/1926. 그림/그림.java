import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 55분
public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // 풀이
        // 상하좌우 네 방향
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = 0; // 최대 너비
        int cnt = 0; // 섬(그림) 개수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                cnt++;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                int area = 0;
                while (!queue.isEmpty()) {
                    area++;
                    int[] temp = queue.poll();
                    int x = temp[0];
                    int y = temp[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (map[nx][ny] == 0 || visited[nx][ny]) continue;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                max = Math.max(max, area);
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
}
