
import java.util.ArrayList;
import java.util.Scanner;
//05 10 15 20
public class Main {
    static ArrayList<Integer> count = new ArrayList<>();
    static int min = 1000000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
//        boolean[] check = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        greedy(n-1,0,k,arr);

        System.out.println(min);

    }
    static void greedy(int i,int c, int k, int[] arr){
        if(i < 0){
            if(k ==0 && c < min){
                min = c;
            }
        }else{
            greedy(i-1,c+(k/arr[i]),k%arr[i],arr);
            greedy(i-1,c,k,arr);
        }
    }
}
