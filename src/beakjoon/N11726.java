import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        int[] dp=new int[N+2];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        System.out.println(dp[N]);
    }
}