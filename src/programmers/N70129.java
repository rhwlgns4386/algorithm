package programmers;

import java.util.Arrays;
import java.util.Collections;

public class N70129 {
    public static void main(String[] args) {
        N70129 object = new N70129();
        System.out.println(Arrays.toString(object.solution("1111111")));
    }
    public int[] solution(String s) {

        int count=0;
        int sum=0;
        while(true){
            if(s.equals("1")){
                break;
            }
            int size=s.length();
            s=s.replace("0","");
            sum+=size-s.length();
            s=Long.toBinaryString(s.length());
            count++;
        }
        int[] answer = new int[2];

        answer[0]=count;answer[1]=sum;
        return answer;
    }
}
