import javax.lang.model.type.ArrayType;
import java.util.Scanner;

//6분
public class Main {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[n];

        back(0,n,check,"");
        System.out.println(sb);

    }
    static void back(int idx, int n, boolean[] check,String str){
        if(idx==n){
            sb.append(str).append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            if(!check[i-1]){
                check[i-1] = true;
                back(idx+1,n,check,str+i+" ");
                check[i-1] = false;
            }
        }
    }
}
