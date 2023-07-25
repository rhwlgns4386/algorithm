package programmers;

import java.util.Arrays;

public class N87390 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3,2,5)));
        System.out.println(Arrays.toString(solution.solution(4,7,14)));
    }
    static class Solution {
        public int[] solution(int n, long left, long right) {

            int count=(int)(right-left)+1;
            int[] answer = new int[count];
            for(int i=0;i<count;i++){
                long row=left/n;
                long colum=left%n;

                answer[i]=colum<=row?(int)row+1:(int)colum+1;
                left++;
            }
            return answer;
        }
    }
}
