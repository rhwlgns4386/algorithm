package programmers;

import java.util.Arrays;
import java.util.Collections;

public class N12941 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[B.length-1-i];
        }

        return answer;
    }
}
