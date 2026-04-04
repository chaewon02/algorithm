import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 34 56
public class Main {
    static int k;
    static ArrayList<Integer> list ;
    static ArrayList<Integer> res = new ArrayList<>() ;
    static boolean[] check ;
    static int cnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        list = new ArrayList<>();
        check = new boolean[n];

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        back(0,"");
        Set<Integer> set = new HashSet<>(res);
//        for(int i : set){
//            System.out.println(i);
//        }
        System.out.println(set.size());


    }
    static void back(int idx, String str){
        if(idx==k){
            //System.out.println(Integer.valueOf(str));
            res.add(Integer.valueOf(str)); // 11 , 121 등등 완성된 정수
            return ;
        }
        for(int i=0;i<list.size();i++){
            if(!check[i]){
                check[i] = true;
                back(idx+1,str+list.get(i));
                check[i] = false;
            }
        }
    }
}
