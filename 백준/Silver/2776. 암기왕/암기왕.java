import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// 암기왕
// 56  26
// sort !! 시간초과
public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            //int n = sc.nextInt();
            int n = Integer.parseInt(br.readLine());
            //int[] memo_1 = new int[n];
            ArrayList<Long> memo_1 = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                memo_1.add(Long.parseLong(st.nextToken()));
            }
            //int m = sc.nextInt();
            int m = Integer.parseInt(br.readLine());
            //int[] memo_2 = new int[m];
            ArrayList<Long> memo_2 = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                memo_2.add(Long.parseLong(st2.nextToken()));
            }

            memo_1.sort(null);

            for(int j=0;j<m;j++){
                int num = BinarySearch(memo_2.get(j),memo_1);
                sb.append(num).append("\n");
            }

        }
        System.out.println(sb);
    }
    static int BinarySearch(long target, ArrayList<Long> memo_1){
        long low = 0; // memo_1 인덱스
        long high = memo_1.size()-1; // memo_1 인덱스
        // 길이일 땐 low,high 인덱스가 아닌 길이 그 자체
        while (low <= high){
            long mid = (low+high)/2;
            //System.out.println(low+" "+mid+" "+high);
            if(memo_1.get((int) mid) == target){
                return 1;
            }else if(memo_1.get((int) mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1 ;
            }
        }

        return 0;
    }
}
