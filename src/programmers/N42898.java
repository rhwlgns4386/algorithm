package programmers;

public class N42898 {
    static int[] dx={0,1};
    static int[] dy={1,0};

    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2, 2}}));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp=new int[n+1][m+1];
        int[][] map=new int[n+1][m+1];
        dp[1][1]=1;
        for(int i=0;i<puddles.length;i++){
            int y = puddles[i][0];
            int x = puddles[i][1];

            map[x][y]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<2;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(n<nx||m<ny||map[nx][ny]==1) continue;
                    dp[nx][ny]=(dp[i][j]%1000000007+dp[nx][ny]%1000000007)%1000000007;

                }
            }
        }

        return dp[n][m]%1000000007;
    }
}
