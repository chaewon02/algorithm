import java.util.ArrayList;
import java.util.Scanner;

// 15 44
public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] check ;
    static int n;
    static int max=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        check = new boolean[n];
        int[] nums = new int[n];
        back(0,nums);
        System.out.println(max);

    }
    static void back(int idx,int[] nums ){
        if(idx == n){
            int sum = 0;
            for(int i=1;i<n;i++){
                sum += Math.abs(nums[i-1]-nums[i]);
            }
            //max
            if(max<sum){
                max = sum;
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                check[i] = true;
                nums[idx]=list.get(i);
                back(idx+1,nums);
                check[i] = false;
            }
        }
    }
}
