

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 1시간
public class Main {
    static ArrayList<int[]> classes = new ArrayList<>();
    static ArrayList<int[]> res = new ArrayList<>();
    static int n ;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            int start = sc.nextInt();
            int end = sc.nextInt() ;
            //int diff = end - start;
            classes.add(new int[]{start,end});
        }
        // end 기준 오름차순 정렬
        Collections.sort(classes,(a, b) -> a[1]==b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

//        for(int[] i : classes){
//            System.out.println(i[1]);
//        }
        Greedy(0,0);
        System.out.println(res.size());

    }
    static void Greedy(int idx, int prev_end){
        if(idx==n){
            return;
        }
        int start = classes.get(idx)[0];
        int end = classes.get(idx)[1];
        //System.out.println(start+" "+prev_end);
        if(start>=prev_end){
            res.add(new int[]{start,end});
            Greedy(idx+1,end);
        }else{
            Greedy(idx+1,prev_end);
        }
    }
}
