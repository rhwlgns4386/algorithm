package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1146 {
    final static int MOD = 1_000_000;
    static long[][] dp1;
    static long[][] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        if(n==1){
            System.out.println(1);
            return;
        }

        dp1=new long[n][n];
        dp2=new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp1[i][j]=dp2[i][j]=-1;
            }
        }

        dp1[1][0] = 1;
        dp1[1][1] = 1;
        dp1[1][2] = 1;
        dp2[0][1] = 1;
        dp2[1][1] = 1;
        dp2[2][1] = 1;

        long sum=0;
        for(int i=0;i<n;i++){
            sum+=f1(n-1-i,i)+f2(n-1-i,i);
            sum%=MOD;
        }
        System.out.println(sum);
    }

    private static long f1(int greater, int smaller) {
        if(dp1[greater][smaller]!=-1) return dp1[greater][smaller];
        if(greater==0) return 0;

        long sum=0;
        for(int i=0;i<greater;i++){
            sum+=f2(greater-1-i,smaller+i);
            sum%=MOD;
        }

        return dp1[greater][smaller]=sum;
    }

    private static long f2(int greater, int smaller) {
        if(dp2[greater][smaller]!=-1) return dp2[greater][smaller];
        if(smaller==0) return 0;

        long sum=0;
        for(int i=0;i<smaller;i++){
            sum+=f1(smaller+greater-1-i,i);
            sum%=MOD;
        }

        return dp2[greater][smaller]=sum;
    }
}
