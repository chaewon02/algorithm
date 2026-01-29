

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//52 11
public class Main {
    static int l;
    static int c;
    static ArrayList<String> list ;
    static boolean[] check = new boolean[c];
    static ArrayList<Character> mol = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken()); // 뽑아야 하는 수열 개수
        c = Integer.parseInt(st.nextToken()); // 문자열 개수

        String[] str = br.readLine().split(" ");
        list = new ArrayList<>(Arrays.asList(str));

        list.sort(null); // 오름차순 정렬

        boolean[] check = new boolean[c];
   
        BackTracking(0,"","", check);
        System.out.println(sb);

    }
    static void BackTracking(int idx, String res,String prev, boolean[] check){
        if(idx==l){
            int mo = 0;
            int ja = 0;
            for(int j=0;j<l;j++){
                if (mol.contains(res.charAt(j))){
                    mo ++;
                } else{
                    ja ++;
                }
            }
            if(mo >= 1 && ja >= 2){
                //System.out.println(res);
                sb.append(res).append('\n');
                return;
            }
        }
        for(int i=0;i<c;i++){
            if(!check[i] && list.get(i).compareTo(prev)>0){
                check[i] = true;
                BackTracking(idx+1,res+list.get(i),list.get(i) ,check);
                check[i] = false;
            }
        }
    }
}
