package programmers;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int[] solution = solution(24, 24);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total=brown+yellow;
        for(int i=1;i<total/2;i++){
            if(total%i==0){
                int x=total/i;
                int y=i;
                int tem=x+x+y+y-4;
                if(tem<=brown){
                    answer[0]=x;
                    answer[1]=y;
                    break;
                }
            }
        }
        return answer;
    }
}
