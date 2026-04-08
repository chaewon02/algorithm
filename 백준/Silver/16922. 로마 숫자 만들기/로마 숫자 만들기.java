import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 27
// 15652
public class Main {
    //static ArrayList<Integer> res = new ArrayList<>();
    static Set<Integer> res = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = {1, 5, 10, 50};
        // 같은 숫자 뽑아도 됨 / 근데 같은 수열은 구하지 않음
        back(0,n,numbers,0,0);
        System.out.println(res.size());

    }
    static void back(int idx, int n, int[] numbers,int num,int prev){
        if(idx == n){
            //System.out.println(num);
            res.add(num);
            return;
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>=prev){
                back(idx+1,n,numbers,num+numbers[i],numbers[i]);
            }
            //back(idx+1,n,numbers,num+numbers[i],numbers[i]);
        }
    }


}
