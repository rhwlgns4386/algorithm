package programmers;

import java.util.Arrays;

public class N92342 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(solution.solution(1,new int[]{1,0,0,0,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(solution.solution(9,new int[]{0,0,1,2,0,1,1,1,1,1,1})));
        System.out.println(Arrays.toString(solution.solution(10,new int[]{0,0,0,0,0,0,0,0,3,4,3})));
        System.out.println(Arrays.toString(solution.solution(3,new int[]{2,1,0,0,0,0,0,0,0,0,0})));
    }

    //dp[]=i발을 쐇을때 최대
    static class Solution {
        int[] answer;
        int MAX;

        public int[] solution(int n, int[] info) {

            answer=new int[info.length];

            int[] result = new int[info.length];
            MAX=0;
            go(info,n,result,0);
            return MAX<=0?new int[]{-1}:answer;
        }

        private void go(int[] info, int n, int[] result, int idx) {
            if(n<=0 || info.length<=idx){
                if(0<n){
                    result[result.length-1]=n;
                }

                int ryan=sum(result,info,false);
                int apeach=sum(info,result,true);

                if(MAX<=ryan-apeach){
                    if(MAX==ryan-apeach && !isMoreSmall(result)) return;
                    MAX=ryan-apeach;
                    answer=Arrays.copyOf(result,result.length);
                }

                if(0<n){
                    result[result.length-1]=0;
                }
                return;
            }

            int ryanArrow = info[idx]+1;
            if(0<=n-ryanArrow){
                result[idx]=ryanArrow;
                go(info,n-ryanArrow,result,idx+1);
                result[idx]=0;
            }

            go(info,n,result,idx+1);
        }

        private boolean isMoreSmall(int[] result) {
            for(int i=result.length-1;0<=i;i--){
                if(result[i]!=answer[i]){
                    if(result[i]<answer[i]){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            return false;
        }

        private int sum(int[] result, int[] info,boolean isApeach) {
            int sum=0;
            for(int i=0;i<info.length;i++){
                if(info[i]==0 && result[i]==0) continue;
                if(info[i]==result[i] && isApeach){
                    sum+=10-i;
                }else if(info[i]<result[i]){
                    sum+=10-i;
                }
            }
            return sum;
        }
    }
}
