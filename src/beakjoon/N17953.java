package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17953 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int day =Integer.parseInt(stringTokenizer.nextToken());
        int dessert=Integer.parseInt(stringTokenizer.nextToken());
        int[][] a = new int[dessert][day];
        int[][] dp=new int[dessert][day];


        for(int i=0;i<dessert;i++){
            stringTokenizer=new StringTokenizer(in.readLine());
            for(int j=0;j<day;j++){
                a[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < dessert; i++) {
            dp[i][0] = a[i][0];
        }
        for(int i=1;i<day;i++){
            for(int j=0;j<dessert;j++){
                for(int k=0;k<dessert;k++){
                    if(j==k){
                        dp[j][i]=Math.max(dp[j][i],dp[k][i-1]+a[j][i]/2);
                    }else {
                        dp[j][i]=Math.max(dp[j][i],dp[k][i-1]+a[j][i]);
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<dessert;i++){
            ans=Math.max(ans,dp[i][day-1]);
        }
        System.out.println(ans);
    }
}
