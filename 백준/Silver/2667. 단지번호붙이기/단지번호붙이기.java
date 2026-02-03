

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 49 58 28
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            String input = sc.next();
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[n][n];

        ArrayList<Integer> cnts = new ArrayList<>();
        int area = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0 || visited[i][j]) continue;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                area++;
                int cnt = 0;

                while (!queue.isEmpty()){
                    cnt ++;
                    int[] poll = queue.poll();
                    int x = poll[1];
                    int y = poll[0];
                    for(int k=0;k<4;k++){
                        int nx = x+ dx[k];
                        int ny = y+ dy[k];
                        if(nx<0||ny<0||nx>=n||ny>=n) continue;
                        if(!visited[ny][nx] && map[ny][nx]==1){
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny,nx});
                        }
                    }
                }
                cnts.add(cnt);
            }
        }
        System.out.println(area);
        cnts.sort(null);
        for(int c : cnts){
            System.out.println(c);
        }
    }
}
