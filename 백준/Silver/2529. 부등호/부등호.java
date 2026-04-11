import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

// 57 42
public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] check = new boolean[10] ;
    static int[] res;
    static long min = (long) 1e10; //1023765489
    static long max = 0;
    static String max_val = "";
    static String min_val = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        res = new int[k+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            String str = st.nextToken();
            if(str.equals(">")){
                list.add(1);
            }else{
                // <
                list.add(2);
            }
        }
        back(0,k+1,res,"");
        System.out.println(max_val);
        System.out.println(min_val);
    }
    static void back(int idx, int k,int[] res, String str){
        if(idx==k){
            int flag = 0; // 문제없음
            for(int i=1;i<k;i++){
                if( list.get(i-1)==1 ){
                    // res[i-1]>res[i]가 아닌 경우 flag 변화
                    if(res[i-1]<res[i]) flag = 1;
                }else{
                    // res[i-1]<res[i]가 아닌 경우 flag 변화
                    if(res[i-1]>res[i]) flag = 1;
                }
            }

            if(flag==0){
                long sum = Long.parseLong(str);
                //System.out.println(sum);
                if(max<sum){
                    max = sum;
                    max_val = str;
                }
                if(min>sum){
                    min = sum;
                    min_val = str;
                }
            }
            return;
        }
        for(int i=0;i<=9;i++){
            if(!check[i]){
                check[i] = true;
                res[idx] = i;
                back(idx+1,k,res,str+i);
                check[i] = false;
            }
        }
    }
}
