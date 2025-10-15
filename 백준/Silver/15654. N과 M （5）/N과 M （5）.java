
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list.sort(null); // 오름차순 정렬
        BackTracking(0,"",list,check);
        System.out.println(sb);

    }
    static void BackTracking(int idx, String res,ArrayList<Integer> list,boolean[] check) {
        if(idx == m) {
            sb.append(res).append('\n');
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!check[i]){
                check[i] = true;
                BackTracking(idx+1,res+list.get(i)+" ",list,check);
                check[i] = false;
            }
        }
    }
}
