

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 09
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> cards = new ArrayList<>();
        for(int i=0;i<n;i++){
            cards.add(Integer.parseInt(st1.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st2.nextToken());
        ArrayList<Integer> confirm = new ArrayList<>();
        for(int i=0;i<m;i++){
            confirm.add(Integer.parseInt(st3.nextToken()));
        }

        cards.sort(null);

        for(int i=0;i<m;i++){
            sb.append((UpperBound(cards,confirm.get(i))-LowerBound(cards,confirm.get(i)))).append(" ");
        }
        System.out.print(sb);

    }
    // 중복 target 중 1번째
    static int LowerBound(ArrayList<Integer> cards, int target){
        int start = 0;
        int end = cards.size();

        while(start<end){
            int mid = (start+end)/2;
            if(cards.get(mid)>=target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    // target 바로 뒤 (타겟보다 하나 뒤)
    static int UpperBound(ArrayList<Integer> cards, int target){
        int start = 0;
        int end = cards.size();

        while (start<end){
            int mid = (start+end)/2;
            if(cards.get(mid)>target){
                end = mid ;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
