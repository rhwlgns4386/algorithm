package programmers.kakao2022internship;

import java.util.Arrays;

public class N118668 {
    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int goalAlp=0;
        int goalCop=0;

        for(int i =0; i<problems.length;i++){
            goalAlp=Math.max(problems[i][0],goalAlp);
            goalCop=Math.max(problems[i][1],goalCop);
        }

        goalAlp=Math.max(goalAlp,alp);
        goalCop=Math.max(goalCop,cop);


        int[][] dp = new int[goalAlp+31][goalCop+31];

        for(int i=0;i<=goalAlp;i++){
            Arrays.fill(dp[i],2250001);
        }

        dp[alp][cop]=0;
        for(int i=alp;i<=goalAlp;i++){
            for(int j=cop;j<=goalCop;j++){
                if(i<goalAlp)dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
                if(j<goalCop)dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
                for(int k=0;k<problems.length;k++){
                    int alp_req = problems[k][0];
                    int cop_req = problems[k][1];
                    int alp_rwd = problems[k][2];
                    int cop_rwd = problems[k][3];
                    int cost = problems[k][4];

                    if(i>=alp_req && j>=cop_req){
                        int nextAlp=i+alp_rwd>goalAlp?goalAlp:i+alp_rwd;
                        int nextCop=j+cop_rwd>goalCop?goalCop:j+cop_rwd;
                        dp[nextAlp][nextCop]=Math.min(dp[i][j]+cost,dp[nextAlp][nextCop]);
                    }
                }

            }
        }

        return dp[goalAlp][goalCop];
    }

}

