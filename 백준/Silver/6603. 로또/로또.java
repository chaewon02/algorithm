
import java.util.ArrayList;
import java.util.Scanner;
// 1
// 체크 숫자 겹침 / f 같은 수열,집합
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            list.add(arr);
        }
        for (int i = 0; i < list.size(); i++) {
            boolean[] check = new boolean[list.get(i).length];
            BackTracking(0,"",list.get(i),check,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void BackTracking(int idx, String res, int[] arr,boolean[] check,int first) {
        if (idx == 6) { // 6개 뽑
            sb.append(res).append('\n');
            return;
        }
        //System.out.println(res+" "+first+" "+check.length+" "+arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (!check[i] && arr[i] > first) {
                check[i] = true;
                BackTracking(idx+1, res+arr[i]+" ", arr,check,arr[i]);
                check[i] = false;
            }
        }
    }
}
