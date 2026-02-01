import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer=-1;
        int max = 0;
        for(int i=0;i<=9;i++){
            max += i;
        }
        for(int i : numbers){
            max -= i;
        }
        answer = max;
        return answer;
    }
}