import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            int arr[] = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j);
            }
            int res[] = new int[s.length()];
            int sum = 0 ;

            for (int j = 0; j < arr.length; j++) {
                res[sum] = arr[j];
                if (sum>0 && res[sum]==res[sum-1]){
                    res[sum] = 0;
                    res[sum-1] = 0;
                    sum = sum-1;
                }else{
                    sum++;
                }
            }
            if (sum==0) cnt++;
        }
        System.out.println(cnt);
    }
}
