package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2281 {

    static final int INF=1000000000;
    private static int[] a;
    private static int N;
    private static int M;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        dp = new int[1000][1002];
        for(int i=0;i<1000;i++){
            for(int j=0;j<1002;j++){
                dp[i][j]=-1;
            }
        }

        for(int i = 0; i< N; i++){
            a[i]=Integer.parseInt(in.readLine());
        }

        System.out.println(go(1,a[0]+1));
    }

    private static int go(int index,int len) {
        if(index==N){
            return 0;
        }
        if(dp[index][len]!=-1)return dp[index][len];

        int left=M-len+1;
        dp[index][len]=go(index+1,a[index]+1)+(left*left);
        if(len+a[index]<=M){
            dp[index][len]=Math.min(dp[index][len],go(index+1,a[index]+1+len));
        }

        return dp[index][len];
    }
}
