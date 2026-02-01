//56 02 17
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //int[] answer = {};
        String[] sp_now = today.split("\\.");
        String d = sp_now[0];
        int now = Integer.parseInt(sp_now[0])*(12*28) +Integer.parseInt(sp_now[1])*28 + Integer.parseInt(sp_now[2]);
        
        Map<String,Integer> dic = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            dic.put(terms[i].split("\\ ")[0],Integer.parseInt(terms[i].split(" ")[1]));
        }
        for(int i=0;i<privacies.length;i++){
            String ymd = privacies[i].split("\\ ")[0];
            String term = privacies[i].split("\\ ")[1];
            
            String[] sp_ymd = ymd.split("\\.");
            int ymd_n = Integer.parseInt(sp_ymd[0])*(12*28) + Integer.parseInt(sp_ymd[1])*28 + Integer.parseInt(sp_ymd[2]);
            int term_n = dic.get(term);
            
            if((now-ymd_n)>=term_n*28){
                ans.add(i+1);
            }
        } 
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
 
        return answer;
    }
}