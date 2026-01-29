import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//28
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(Integer.parseInt(st2.nextToken()));
        }
        tree.sort(null); // 오름차순
        long res = BinarySearch(tree,m);

        System.out.println(res);
        // 절단기 설정값 : mid / 0~최댓값 mid
        // 주어진 값 7(m)
    }
    static long BinarySearch(ArrayList<Integer> tree,long target){
        long start = 0;
        long end = tree.get(tree.size()-1); // 최댓값
        long max = 0;
        //10 15 17 20
        //mid=10 (my=22) -> mid 커져야함
        while(start<=end){
            long mid = (start + end)/2;
            long my_tree = 0;
            for(int i=0;i<tree.size();i++){
                long cut = tree.get(i) - mid;
                if(cut>0){
                    my_tree += cut;
                }
            }
            //System.out.println(mid +" "+ my_tree);

            if(my_tree>=target){
                if(max<mid){
                    max = mid;
                }
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return max;
    }

}
