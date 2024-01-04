package programmers;

public class N12929 {
    static class Solution {
        static int[] dp=new int[14+1];
        static {
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<dp.length;i++){
                for(int j=0;j<i;j++){
                    dp[i]+=dp[j]*dp[i-j-1];
                }
            }
        }
        public int solution(int n) {
            return dp[n];
        }
    }
}
