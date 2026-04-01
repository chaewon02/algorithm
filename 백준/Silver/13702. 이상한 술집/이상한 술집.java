import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 13분
// 술집 (save)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 친구
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            //StringTokenizer st2 = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(null);

        System.out.println(bs(k,list));

    }
    static long bs(int k, ArrayList<Integer> list){
        long low = 1 ;
        long high = list.get(list.size()-1);
        long max = 0;

        while (low<=high){
            long mid = (low+high)/2;
            int num = 0;
            for(int i=0;i< list.size();i++){
                num += list.get(i)/mid;
            }
            if(num>=k){
                if(max<mid){
                    max = mid;
                }
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return max;
    }
}
