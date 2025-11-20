
import java.util.*;

public class Main {
    static int m ;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        arr.sort(null); // 오름
        Back(0,arr,"",0);
       for ( String s : set) {
           sb.append(s).append('\n');
       }
        System.out.println(sb);

    }

    static void Back(int idx, ArrayList<Integer> arr,String res, int first) {
        if(idx==m){
            set.add(res.trim()); // 문자열 앞뒤공백 제거
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>=first){
                Back(idx+1,arr,res+arr.get(i)+" ",arr.get(i));
            }
        }
    }
}
