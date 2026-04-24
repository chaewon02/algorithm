class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //9
        String answer = "";
        String[] time = video_len.split(":");
        int len_time = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
        time = pos.split(":");
        int pos_time = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
        time = op_start.split(":");
        int op_start_time = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
        time = op_end.split(":");
        int op_end_time = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
        
        for(String c : commands){
            // 오프닝구간인지
            if(op_start_time<=pos_time && pos_time<=op_end_time){
                pos_time=op_end_time;
            }
            // next,prev 동영상 길이 넘는지 0~len
            if(c.equals("next")){
                pos_time += 10;
            }else{
                pos_time -= 10;
            }
            
            if(pos_time<0){
                pos_time=0;
            }else if(pos_time >len_time){
                pos_time=len_time;
            }
            // 오프닝구간인지
            if(op_start_time<=pos_time && pos_time<=op_end_time){
                pos_time=op_end_time;
            }
        }
        if(pos_time/60>=10){
            answer += pos_time/60;
        }else{
            answer += "0";
            answer += pos_time/60;
        }
        answer += ":";
        if(pos_time%60>=10){
            answer += pos_time%60;
        }else{
            answer += "0";
            answer += pos_time%60;
        }
        
        
        //System.out.println(Integer.valueOf(a[0])*60+Integer.valueOf(a[1]));
        return answer;
    }
}