class Solution {
    // 40
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 6, 7은 놉 startday%7로 관리
        for(int i=0;i<schedules.length;i++){
            int flag = 0; //지각안함
            int goal = schedules[i];
            System.out.print(goal);
                    goal = goal +10;
                    goal = (goal%100>=60) ? (goal/100+1)*100 +goal%10 : goal;
                    System.out.println(goal);
            for(int time : timelogs[i]){
                if(startday==0) startday++;
                if(startday==6 || startday==7) {
                    startday = (startday+1)%8;
                }else{
                    if(goal<time) flag = 1; //지각함
                    startday = (startday+1)%8;
                }
            }
            //System.out.println(flag);
            if(flag==0)  answer++;
        }
        return answer;
    }
}