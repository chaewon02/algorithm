
import java.util.ArrayList;
import java.util.Scanner;

//39 45
// check -> 수열 안 같은 숫자 방지 / first -> 중복되는 수열 (집합) 방지
//
public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        arr.sort(null); // 오름차순 정렬

        BackTracking(0,"",arr,check,0);
        System.out.println(sb);
    }
    private static void BackTracking(int idx, String res, ArrayList<Integer> arr, boolean[] check,int first) {
        if(idx == m) {
            sb.append(res).append('\n');
            return;
        }

        for(int i = 0; i < arr.size(); i++) {
            if(!check[i] && arr.get(i) > first) {
                check[i] = true;
                BackTracking(idx+1, res+arr.get(i)+" ", arr, check, arr.get(i));
                check[i] = false;
            }
        }

    }
}
