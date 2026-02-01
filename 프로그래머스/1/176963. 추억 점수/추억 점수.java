//10
import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> dic = new HashMap<>();
        for(int i=0;i<name.length;i++){
            dic.put(name[i],yearning[i]);
        }
        for(int i=0;i<photo.length;i++){
            for(int j=0;j<photo[i].length;j++){
                if(dic.keySet().contains(photo[i][j])){
                    answer[i] += dic.get(photo[i][j]);
                }
            }
        }
        return answer;
    }
}