import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//39 -5 -24 06
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken()); //a
            int m = Integer.parseInt(st1.nextToken()); //b
            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> bList = new ArrayList<>();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                aList.add(Integer.parseInt(st2.nextToken()));
            }

            StringTokenizer st3 = new StringTokenizer(br.readLine());
            bList.add(0);
            for(int j=0;j<m;j++){
                bList.add(Integer.parseInt(st3.nextToken()));
            }

            bList.sort(null);
            int res = 0;
            for(int j=0;j<n;j++){
                res += BinarySearch(aList.get(j),bList);
            }
            System.out.println(res);
        }

    }
    static int BinarySearch(int target,ArrayList<Integer> bList){
        int low = 1;
        int high = bList.size();
        //int res = 0;
        // 1 2 3 5 / 4 작으면 low = mid +1
        // 8 1 7 3 1 target
        // 1 3 6
        // 11 103 215 290 2
        while(low<high){
            int mid = (low+high) / 2;
            if(bList.get(mid)<target){
                low = mid + 1 ;
            }else{
                high = mid ;
            }
        }
        //System.out.println(--low);
        return --low;
    }
}
