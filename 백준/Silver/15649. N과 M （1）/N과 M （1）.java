import java.util.ArrayList;
import java.util.Scanner;

// 기본 ! (save)
// 10분
// check -> 같은 숫자 방지 ex) 1 1
// 중복 방지는 list가 1~n으로 각자 다른 숫자라서 가능 -> 같은 수가 존재하는 경우에는 set
public class Main {
    static int m;
    static boolean[] check ;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        check = new boolean[n];

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        back(0,list,"");
        System.out.println(sb);

    }
    static void back(int idx, ArrayList<Integer> list, String str){
        if(idx == m){
            sb.append(str).append("\n");
            return;
        }
        for(int i=0;i<list.size();i++){
            if(!check[i]){
                check[i] = true;
                back(idx+1,list,str+list.get(i)+" ");
                check[i] = false;
            }
        }
    }
}
