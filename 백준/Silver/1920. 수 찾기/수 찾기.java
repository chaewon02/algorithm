
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int[] arr = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
            //System.out.print(arr[i]+" ");
        }
        arr.sort(null);

        int m = scanner.nextInt();
        int[] search = new int[m];
        for (int i = 0; i < m; i++) {
            search[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.println(BinarySearch(arr, search[i]));
        }


    }
    static int BinarySearch(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int mid;
        while (low <= high) {
           mid = (low+high)/2;
           //System.out.print(mid);
           if(arr.get(mid)== target) {
               return 1;
           } else if(arr.get(mid) > target){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
        }
        return 0;
    }
}