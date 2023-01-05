package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());

        int A[]=new int[N];
        int dp[]=new int[N];
        Arrays.fill(dp,1001);

        dp[0]=0;
        StringTokenizer st=new StringTokenizer(in.readLine()," ");
        for (int i = 0; i <N ; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <=A[i]; j++) {
                if(i+j<N){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }

        System.out.println(dp[N-1]==1001?-1:dp[N-1]);
    }
}
