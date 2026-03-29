import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 42 27
// 특정 길이로 나눈 거 더한 값이 조카 수여야 함
public class Main {
    public static void main(String[] args) throws IOException {
        // mid 과자길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> snack = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            snack.add(Integer.parseInt(st2.nextToken()));
        }
        snack.sort(null);
        System.out.println(BinarySearch(n,snack));

    }
    static int BinarySearch(int n,ArrayList<Integer> list){
        int low = 1; // 과자의 길이 1~
        int high = list.get(list.size()-1); // 최댓값
        int max = 0;

        while(low<=high){
            int mid = (low+high)/2; //5
            int num = 0;
            for(int i=list.size()-1;i>=0;i--){
                int snack = list.get(i) ;
                num += snack/mid; // 조카한테 준 스낵 개수
            }
            if(num>=n){
                // 준 총 스낵 개수가 조카 수와 일치 할 경우 -> 가장 큰 값
                if(max<mid){
                    max = mid;
                }
                //System.out.println("max: "+max+", mid: "+mid);
                low = mid + 1;
            } else{
                high = mid - 1;
            }
//            else if(num>n){
//                low = mid + 1;
        }
        return max;
    }
}
