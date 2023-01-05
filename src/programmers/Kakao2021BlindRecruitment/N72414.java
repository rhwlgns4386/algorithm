package programmers.Kakao2021BlindRecruitment;

public class N72414 {
    public static void main(String[] args) {
        System.out.println(solution("00:00:10","00:00:05",new String[]{"00:00:08-00:00:10"}));
    }

    static long[] logFre;
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTimeNum=makeSec(play_time);
        int advTimeNum=makeSec(adv_time);
        logFre=new long[playTimeNum+1];
        for(int i=0;i<logs.length;i++){
            String[] log = logs[i].split("-");
            int from=makeSec(log[0]);
            int to=makeSec(log[1]);
            logFre[from]+=1;
            logFre[to]-=1;
        }

        for(int i=1;i<=playTimeNum;i++){
            logFre[i]+=logFre[i-1];
        }

        for(int i=1;i<=playTimeNum;i++){
            logFre[i]+=logFre[i-1];
        }

        long temSum=0;
        int lo=0;
        for(int i=0;i<=playTimeNum-advTimeNum;i++){
            long sum=0;
            if(i==0){
                sum=logFre[i+advTimeNum-1];
            }
            else{
                sum=logFre[i+advTimeNum-1]-logFre[i-1];
            }

            if(temSum<sum){
                temSum=sum;
                lo=i;
            }
        }

        return intToStr(lo);
    }

    static int makeSec(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*3600+Integer.parseInt(split[1])*60+Integer.parseInt(split[2]);
    }

    public static String intToStr(int time){
        String hh, mm, ss;
        hh= (time/3600)>9? (time/3600)+"":"0"+time/3600;
        time%=3600;
        mm= (time/60)>9? (time/60)+"":"0"+time/60;
        time%=60;
        ss= time>9? time+"":"0"+time;

        return hh+":"+mm+":"+ss;
    }
}
