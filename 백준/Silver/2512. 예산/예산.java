
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 32 22
public class Main {
    static ArrayList<Integer> cost = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            cost.add(sc.nextInt());
        }
        int m = sc.nextInt();
        Collections.sort(cost);

        System.out.println(BinarySearch(m));


    }

    static int BinarySearch(int target){
        int start = 1;
        int end = cost.get(cost.size()-1);
        int max = 0;
        int res =0;

        while(start<=end){
            int mid = (start+end)/2;
            int total =0;
            for(int c : cost){
                if(c>=mid){
                    total += mid;
                }else{
                    total += c ;
                }
            }
            //System.out.println(mid+" "+total+" "+end);
            if(total <= target){
                if(total>max) {
                    max = total;
                    res = mid;
                }
                start = mid+1;
                //System.out.println(start);
            }else{
                end = mid-1;
            }
        }
        return res;
    }
}
