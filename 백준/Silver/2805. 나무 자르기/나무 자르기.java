
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        arr.sort(null);
        long res = BinarySearch(arr, m);
        System.out.println(res);
    }
    static long BinarySearch(ArrayList<Integer> arr, int target) {
        long low = 0;
        long high = 1000000001;
        long mid = 0;
        long res = 0;
        while (low <= high) {
            mid = (low+high) / 2;
            long height = 0;
            for(int i : arr){
                if(i>=mid){
                    height += i - mid ; // 잘라낸 나무 길이 5 0 () 2 = 7
                }
            }
            if(height>=target){
                res = Math.max(res, mid);
                //res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}
