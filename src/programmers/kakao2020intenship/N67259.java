package programmers.kakao2020intenship;

import java.util.Arrays;
import java.util.LinkedList;

public class N67259 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    static int n;
    static int m;

    static class Pair{
        int x;
        int y;
        int direction;

        public Pair(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static int solution(int[][] board) {
        n=board.length;
        m=board[0].length;
        int answer = Integer.MAX_VALUE;

        int[][][] dp=new int[n+1][m+1][4];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],376000);
            }
        }

        bfs(dp,board);

        for(int i=0;i<4;i++){
            answer=Math.min(answer,dp[n-1][m-1][i]);
        }
        return answer-100;
    }

    //dp 3차원 0은 오른쪽 1은 왼쪽 2는 아래 3은 상단
    private static void bfs(int[][][] dp, int[][] board) {
        LinkedList<Pair> q = new LinkedList<>();
        dp[0][0][0]=100;
        dp[0][0][2]=100;
        q.add(new Pair(0,0,0));
        q.add(new Pair(0,0,2));
        while (!q.isEmpty()){
            Pair pair = q.remove();
            int x=pair.x;
            int y=pair.y;
            int dir=pair.direction;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || n<=nx || ny<0 || m<=ny ||board[nx][ny]==1)continue;

                if(i==dir){
                    if(dp[x][y][dir]+100<=dp[nx][ny][i]){
                        dp[nx][ny][i]=dp[x][y][i]+100;
                        q.add(new Pair(nx,ny,i));
                    }
                }else{
                    if(dp[x][y][dir]+600<=dp[nx][ny][i]){
                        dp[nx][ny][i]=dp[x][y][dir]+600;
                        q.add(new Pair(nx,ny,i));
                    }
                }
            }
        }
    }
}
