//40 53 -> 13
class Solution {
    public int solution(String s) {
        int answer = 0;
        int x_cnt=0;
        int cnt=0;
        Character start = s.charAt(0);
        
        for(int i=0;i<s.length();i++){
            if(x_cnt==cnt){
                x_cnt=0;
                cnt=0;
                start = s.charAt(i);
                answer ++;
            }
            if(start == s.charAt(i)){
                x_cnt++;
            }else{
                cnt++;
            }
        }
        return answer;
    }
}