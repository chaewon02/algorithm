

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 34 54 59
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[] dx = {0,1};
        int[] dy = {1,0};

        int res = 0 ;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int num = map[x][y];
//            if(num==0){
//                break;
//            }

            for(int k=0;k<2;k++){
                int nx = x + dx[k]*num;
                int ny = y + dy[k]*num;
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                //System.out.println(nx+" "+ny+" "+visited[nx][nx]);
                if(visited[nx][ny]==1) continue;
//                res = map[nx][ny];
//                if(nx==n-1&&ny==n-1){
//                    break;
//                }
                queue.add(new int[]{nx,ny});
                visited[nx][ny]=1;
            }
        }
        //System.out.println(visited[n-1][n-1]);
        if(visited[n-1][n-1]==1){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }
}
