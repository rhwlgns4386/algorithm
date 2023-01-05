package programmers;

public class N12945 {

    public static int[] dp;

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        return fibo(n);
    }

    private static int fibo(int n) {
        if(n<2)return dp[n];
        if(dp[n]!=0) return dp[n];
        dp[n]= (fibo(n-1)+fibo(n-2))%1234567;
        return dp[n];
    }
}
