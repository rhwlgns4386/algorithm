package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class N12938 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(9999,100000000)));
    }
    public static int[] solution(int n, int s) {
        double divideNum=(double) s/(double) n;
        if(divideNum<1){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        double ceilNumber=Math.ceil(divideNum);
        double floorNumber=Math.floor(divideNum);

        int cnt=(int)Math.round(((divideNum-floorNumber)*n));
        for(int i=0;i<n-cnt;i++){
            answer[i]=((int)floorNumber);
        }
        for(int i=n-cnt;i<n;i++){
            answer[i]=((int)ceilNumber);
        }
        return answer;
    }
}
