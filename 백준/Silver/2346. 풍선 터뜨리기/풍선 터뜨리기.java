import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        int r=0; //res 인덱스
        int res[] = new int[N];
        int K = 0; // 기준
        int k = 0; // 카운트

        while (true){
            if(r==N) break;

            if(arr[i]==0){
                if (K>0){
                    i++;
                    if(i>=N) i=0;
                }else{
                    i--;
                    if(i==-1) i=N-1;
                }
                continue;
            }
            if(k==Math.abs(K)){
                res[r] = i+1 ;
                K=arr[i];
                arr[i] = 0;
                r++;
                k=0;
            }

            if (K>0){
                i++;
                if(i>=N) i=0;
            }else{
                i--;
                if(i==-1) i=N-1;
            }
            k++;
        }

        for(int j=0;j< res.length;j++){
            if(j==res.length-1) System.out.println(res[j]);
            else{
                System.out.print(res[j]+ " ");
            }
        }
    }
}
