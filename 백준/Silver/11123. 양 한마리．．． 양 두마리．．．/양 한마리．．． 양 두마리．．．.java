
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            String[][] map = new String[h][w];
            boolean[][] visited = new boolean[h][w];
            for (int n = 0; n < h; n++) {
                String line = br.readLine();
                for(int m = 0; m < w; m++) {
                    map[n][m] = String.valueOf(line.charAt(m));
                }
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int cnt = 0; // 무리 개수

            for (int n = 0; n < h; n++) {
                for (int m = 0; m < w; m++) {
                    if(map[n][m].equals(".")||visited[n][m]) continue;
                    visited[n][m] = true;
                    cnt++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{n, m});

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                            if(map[nx][ny].equals("#") && !visited[nx][ny]){
                                queue.add(new int[]{nx, ny});
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
