//9 14 51
import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i=0;i<6;i++){
            arr1.add(lottos[i]);
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i=0;i<6;i++){
            arr2.add(win_nums[i]);
        }
        
        for(int i=0;i<arr1.size();i++){
            if(arr1.get(i)==0){
                zero++;
                continue;
            }
            if(arr2.contains(arr1.get(i))){
                cnt++;
            }
        }
        int gr = cnt+zero;
        for(int i=0;i<2;i++){
            if(gr==6){
                answer[i]=1;
            }else if(gr==5){
                answer[i]=2;
            }else if(gr==4){
                answer[i]=3;
            }else if(gr==3){
                answer[i]=4;
            }else if(gr==2){
                answer[i]=5;
            }else{
                answer[i]=6;
            }
            gr -= zero;
        }
        
        return answer;
    }
}