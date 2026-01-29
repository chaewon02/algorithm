

import java.util.ArrayList;
import java.util.Scanner;

//10 51
public class Main{
    static Scanner scanner = new Scanner(System.in);
    static int n = scanner.nextInt();
    static int s = scanner.nextInt();
    static int res = 0;

    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[n];

    public static void main(String[] args){
        //ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(scanner.nextInt());
        }

        arr.sort(null); // 오름차순

        int dept = 0;
        int sum = 0;
        BackTracking(sum, dept);

        if(s==0){
            System.out.println(res-1); // 아무 원소도 포함하지 않는 경우 -> 공집합 제외
        }else{
            System.out.println(res);
        }

    }
    static void BackTracking(int sum, int dept){
        if(dept==n){
            if(sum==s){
                //System.out.println("dept: "+dept+"sum: "+sum);
                res ++;
            }
        }else{
            BackTracking(sum+arr.get(dept), dept+1); // 더하거나
            BackTracking(sum,dept+1); // 안 더하거나
        }
    }

}
