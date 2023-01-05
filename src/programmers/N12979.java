package programmers;

import java.util.Arrays;

public class N12979 {
    public static void main(String[] args) {
        System.out.println(solution(20,new int[]{5,10,15,20},1));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int weight=w*2+1;


        int lastIndex=1;
        for(int i=0;i<stations.length;i++){
            int temp=stations[i];
            int len =  temp-w-lastIndex ;
            if(0<len){
                answer+=Math.ceil((float)len/(float) weight);
            }
            lastIndex=temp+w+1;
        }

        if(lastIndex<=n){
            int len=n+1-lastIndex;
            answer+=Math.ceil((float)len/(float) weight);
        }

        return answer;
    }
}
