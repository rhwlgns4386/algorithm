package programmers;

import java.util.ArrayList;
import java.util.Comparator;

public class N17676 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution.solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
        System.out.println(solution.solution(new String[]{"2016-09-15 03:10:33.020 0.011s"}));
        System.out.println(solution.solution(new String[]{"2016-09-15 03:10:33.020 0.011s","2016-09-15 03:10:33.020 0.011s","2016-09-15 03:10:33.020 0.011s"}));
        System.out.println(solution.solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
    }

    static class Solution {
        public int solution(String[] lines) {

            ArrayList<Log> a = new ArrayList<>();
            for(int i=0;i<lines.length;i++){
                Log log = new Log(lines[i]);
                a.add(log);
            }

            a.sort(Comparator.comparingInt(l -> l.startTime));
            a.sort(Comparator.comparingInt(l -> l.endTime));

            int result=0;
            for(int i=0;i<a.size();i++){
                Log here = a.get(i);
                int boundary = here.endTime + 1000-1;
                int count=1;
                for(int j=0;j<a.size();j++){
                    Log next = a.get(j);
                    if(i==j) continue;
                    if(next.endTime<here.endTime || boundary<next.startTime) continue;
                    count++;
                }

                result=Math.max(result,count);
            }

            return result;
        }

        private class Log {
            private String time;
            private int startTime;
            private int endTime;
            public Log(String line) {
                String[] s = line.split(" ");
                time=s[1];
                endTime=endTimeStringToInt(s[1]);
                startTime=endTime-processingTimeStringToInt(s[2])+1;
            }

            private int processingTimeStringToInt(String s) {
                double d=Double.parseDouble(s.replace("s", ""));

                return (int)(d*1000);
            }

            private int endTimeStringToInt(String str) {
                String[] split = str.split(":");
                int h = Integer.parseInt(split[0])*3600*1000;
                int m=Integer.parseInt(split[1])*60*1000;
                int s=(int)(Double.parseDouble(split[2])*1000);
                return h+m+s;
            }
        }
    }
}
