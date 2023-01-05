package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class N12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int aPoint=0;
        int bPoint=0;
        for(int i=0;i<A.length;i++){
            if(B[bPoint]<=A[aPoint]){
                bPoint++;
            }else{
                aPoint++;
                bPoint++;
                answer++;
            }
        }
        return answer;
    }
}
