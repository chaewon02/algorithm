import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 8분
// save
public class Main {
    static int m;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st2.nextToken()));
        }
        list.sort(null);
        back(0,"");
        System.out.println(sb);

    }
    static void back(int idx,String str){
        if(idx==m){
            sb.append(str).append("\n");
            return;
        }
        for(int i=0;i<list.size();i++){
            back(idx+1,str+list.get(i)+" ");
        }
    }
}
