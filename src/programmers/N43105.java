package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N43105 {

    static int[][] triangles;
    static int[][] dp;
    public static int solution1(int[][] triangle) {
        int answer = 0;
        triangles=triangle;
        dp=new int[501][501];


        dp[0][0]=triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]+triangle[i][j]);
                if(j!=0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+triangle[i][j]);
                }
            }
        }

        for(int i=0;i<triangle[triangle.length-1].length;i++){
            answer=Math.max(dp[triangle.length-1][i],answer);
        }
        return answer;
    }

    public static int solution2(int[][] triangle) {
        int answer = 0;
        triangles=triangle;
        dp=new int[501][501];
        for(int i=0;i<501;i++){
            Arrays.fill(dp[i],-1);
        }

        answer=path2(0,0);
        return answer;
    }

    public static int path2(int x,int y){
        if(x==triangles.length-1) return triangles[x][y];

        int ret=dp[x][y];
        if(ret!=-1) return dp[x][y];
        return dp[x][y]=Math.max(path2(x+1,y),path2(x+1,y+1))+triangles[x][y];
    }
}
