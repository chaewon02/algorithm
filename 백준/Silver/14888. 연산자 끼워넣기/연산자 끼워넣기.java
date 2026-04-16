import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//29
public class Main {
    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<Integer> math = new ArrayList<>();
    static boolean[] check ;
    static long max = (long) -1e10;
    static long min = (long) 1e10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st2.nextToken());
            for(int j=0;j<num;j++){
                math.add((i+1));
            }
        }
        check = new boolean[math.size()];
        int[] res = new int[math.size()];
        back(0,res);
        System.out.println(max);
        System.out.println(min);

    }
    static void back(int idx,int[] res){
        if(idx == math.size()){
            //계산
            int sum = numbers.get(0);
            for(int i=0;i<math.size();i++){
                // 마지막 인덱스 주의
                int num = res[i];
                if(num==1){
                    sum += numbers.get(i+1);
                }else if(num==2){
                    sum -= numbers.get(i+1);
                }else if(num==3){
                    sum *= numbers.get(i+1);
                }else{
                    sum /= numbers.get(i+1);
                }
            }
            if(max<sum) max = sum;
            if(min>sum) min = sum;
            return;
        }
        for(int i=0;i<math.size();i++){
            if(!check[i]){
                check[i]=true;
                res[idx] = math.get(i);
                back(idx+1,res);
                check[i]=false;
            }
        }
    }
}
