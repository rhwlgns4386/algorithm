package programmers;

public class N140105 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,1));
    }

    static class Solution {
        public int solution(int n, int count) {
            long[][] dp=new long[n+1][count+1];
            dp[1][1]=1;
            for(int i=2;i<=n;i++){
                for(int j=1;j<=count;j++){
                    dp[i][j]=(((i-1)*2*dp[i-1][j])+dp[i-1][j-1])%1000000007;
                }
            }
            return (int)dp[n][count];
        }
    }
}
