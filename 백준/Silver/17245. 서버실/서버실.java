import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 00
public class Main{
    static long max ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //int[][] server = new int[n][n];

        ArrayList<Long> server = new ArrayList<>();
        long sum = 0;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                long temp = Integer.parseInt(st.nextToken());
                server.add(temp);
                sum += temp;
            }
        }
        server.sort(null);
        max = server.get(server.size()-1);
        long res = 0;
        //System.out.println(sum);

        if(sum==0){
            System.out.println(0);
            return;
        }


//        for(int i=1;i<=max;i++){
//            long num = server.size() - UpperBound(i,server) ;
//            System.out.println(num);
//            res += num ;
//            if(res>=sum/2){
//                System.out.println(res);
//                System.out.println(i);
//                break;
//            }
//        }
        System.out.println(bs(sum,server));
        // mid 시간 -> 인덱스
        // 50퍼 이상인 값 ex) 50
        // 0000 1111 22 33 444 555 6 777 8 9
        // 1일 때 개수 -> 2 개수 -> 3개수 (50보다 크면 멈춤) sum/2



    }
    // 중복 중 처음 인자
    static long bs(long target, ArrayList<Long> server){
        long low = 0;
        long high = max; // 시간
        long ans = 0;

        while(low <= high){
            long mid = (low+high)/2;
            long res = 0;
            for(long c : server){
                if(c<=mid){
                    res += c ;
                }else{
                    res += mid ;
                }
            }
            if(res*2>=target){
                ans = mid;
                high = mid -1 ;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    // 중복수 바로 다음 수
    static long UpperBound(int target, ArrayList<Long> server){
        long low = 0;
        long high = server.size();
        while(low < high){
            long mid = (low+high)/2;
            if(server.get((int) mid)>target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }



}
