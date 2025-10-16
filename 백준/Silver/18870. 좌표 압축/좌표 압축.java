
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 20 23 35 45 51 05 15
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr_sort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr_sort.add(scanner.nextInt());
        }
        for(int i=0; i<n; i++){
            arr.add(arr_sort.get(i));
        }

        Set<Integer> set = new HashSet<>(arr_sort);
        ArrayList<Integer> arr_sort_set = new ArrayList<>(set);
        arr_sort_set.sort(null);
        
//        for(int i=0; i<arr_sort_set.size(); i++){
//            System.out.print(arr_sort_set.get(i)+" ");
//        }
//        System.out.println();

        for (int i = 0; i < n; i++) {
            int idx = LowBound(arr_sort_set, arr.get(i));
            sb.append(idx).append(" ");
        }
        System.out.println(sb);

    } 
    //-10 -9 2 4 (5-3)
    // 999 999 999 1000 1000 1000
    static int LowBound(ArrayList<Integer> arr, int target){
        int low = 0;
        int high = arr.size();
        while (low < high){
            int mid = (low+high) / 2;
            if(arr.get(mid) >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
