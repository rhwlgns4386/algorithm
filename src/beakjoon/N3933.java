package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3933 {
    static final int MAX=(int)Math.pow(2,15);
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int dp[][]=new int[MAX+10][5];
        for(int i=1;i*i<MAX;i++){

            dp[i*i][1]=1;

            for(int j=i*i;j<MAX;j++){
                dp[j][2]+=dp[j-i*i][1];
                dp[j][3]+=dp[j-i*i][2];
                dp[j][4]+=dp[j-i*i][3];
            }
        }

        while (true){
            int N=Integer.parseInt(in.readLine());

            if(N==0)break;

            int ans = 0;  /* 4개 이하의 제곱수의 합으로 N 을 표현할 수 있는 경우의 수 */
            for (int i=1; i<=4; i++) {
                ans += dp[N][i];
            }

            System.out.println(ans);
        }
    }
}
