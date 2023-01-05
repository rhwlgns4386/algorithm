package programmers.Kakao2022BlindRecruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N92334 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"con", "ryan","aa","bb","cc","dd","dc","ad","qd","nmd"}, new String[]{"ryan con"}, 1);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        boolean[][] reportCheckList=new boolean[1001][1001];
        int[] reportList=new int[1001];

        HashMap<String, Integer> idMap = new HashMap<>();

        for(int i=0;i<id_list.length;i++){
            idMap.put(id_list[i],i);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i <report.length ; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(report[i], " ");
            int defendant=idMap.get(stringTokenizer.nextToken());
            int plaintiff=idMap.get(stringTokenizer.nextToken());

            if(!reportCheckList[defendant][plaintiff]){
                reportCheckList[defendant][plaintiff]=true;
                reportList[plaintiff]+=1;
            }
        }

        for (int i = 0; i <id_list.length ; i++) {
            if(reportList[i]>=k){
                for (int j = 0; j < id_list.length; j++) {
                    if(reportCheckList[j][i]){
                        answer[j]+=1;
                    }
                }
            }
        }
        return answer;
    }
}
