
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Integer> a_arr = new ArrayList<>();
        ArrayList<Integer> b_arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            a_arr.add(sc.nextInt());
        }
        a_arr.sort(null);
        for (int i = 0; i < b; i++) {
            b_arr.add(sc.nextInt());
        }
        b_arr.sort(null);

        int cnt = 0;
        for (int i = 0; i < a_arr.size(); i++) {
            if(BinarySearch(b_arr,a_arr.get(i))==-1){
                cnt++;
                sb.append(a_arr.get(i)+" ");
            }
        }
        if(cnt==0){
            System.out.println(0);
        }else{
            System.out.println(cnt);
            System.out.println(sb);
        }
    }

    static int BinarySearch(ArrayList<Integer> b_arr,int target) {
        int low = 0;
        int high = b_arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(b_arr.get(mid) == target){
                return 1 ;
            }else if(b_arr.get(mid)>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
