

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 07 33
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            //str.charAt(j)-'0';
                //Character.getNumericValue(str.charAt(j))
            }
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[n][m];
        int cnt = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,cnt});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int len = poll[2];
            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0||ny<0||nx>=m||ny>=n) continue;
                if(map[ny][nx]==1 && !visited[ny][nx]){
                    if(ny==n-1 && nx==m-1){
                        System.out.println(len+1);
                        return;
                    }
                    queue.add(new int[]{ny,nx,len+1});
                    visited[ny][nx] = true;
                }
            }
        }
        //System.out.println(cnt);
    }
}
