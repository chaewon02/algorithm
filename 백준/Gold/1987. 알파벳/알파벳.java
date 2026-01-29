
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//30 -2 30
//
public class Main {
    static int r ;
    static int c ;
    static int[] dx = {-1,1,0,0}; // c
    static int[] dy = {0,0,-1,1}; // r
    static char[][] map ;
    static boolean[][] visited ; // 중복 위치 불가
    static ArrayList<Character> chars = new ArrayList<>() ; // 중복 단어 불가
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c]; // 중복 위치 불가
        //int res = 1;

        for(int i=0;i<r;i++){
            String str = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = str.charAt(j);
            }
        }

        visited[0][0] = true;
        chars.add(map[0][0]);
        BackTracking(0,0,1);

//        while(!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int x = poll[1];
//            int y = poll[0];
//            int dist = poll[2];
//            for(int k=0;k<4;k++){
//                int ny = y + dy[k];
//                int nx = x + dx[k];
//                if(nx<0||ny<0||nx>=c||ny>=r) continue;
//                if(!visited[ny][nx] && !chars.contains(map[ny][nx])){
//                    visited[ny][nx] = true;
//                    chars.add(map[ny][nx]);
//                    queue.add(new int[]{ny,nx,dist+1});
//                    chars.clear();
//                }
//            }
//        }

        System.out.println(max);


    }

    static void BackTracking(int x,int y,int dist){
        for(int k=0;k<4;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(max<dist){
                max = dist;
            }
            if(nx<0||ny<0||nx>=c||ny>=r) continue;
            if(!visited[ny][nx] && !chars.contains(map[ny][nx])){
                visited[ny][nx] = true;
                chars.add(map[ny][nx]);
                //System.out.println("dist: "+(dist+1)+" " +map[ny][nx]+" arr:"+chars);
                BackTracking(nx,ny,dist+1);
                chars.remove(chars.size()-1);
                visited[ny][nx] = false;
            }
        }
    }

}
