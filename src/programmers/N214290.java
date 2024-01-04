package programmers;

import java.util.HashMap;

public class N214290 {

    public static void main(String[] args) {

    }

    static class Solution {

        static int[] dx = {0, 0, -1, 1};
        static int[] dy = {-1, 1, 0, 0};
        static final long MOD_NUMBER=1_000_000_007;

        public int solution(int[][] grid, int[] d, int k) {
            int answer = 0;
            boolean[][][] dp = new boolean[d.length][grid.length][grid[0].length];

            for(int dIdx=0;dIdx<d.length;dIdx++){
                for(int i=0;i<grid.length;i++){
                    for(int j=0;j<grid.length;j++){
                        for(int direction=0;direction<4;direction++){
                            int nx=i+dx[direction];
                            int ny=j+dy[direction];
                            if(inRange(grid,nx,ny)){
                                dp[dIdx][i*grid[0].length+j][nx*grid[0].length+ny]=grid[nx][ny]-grid[i][j]==d[dIdx];
                            }
                        }
                    }
                }
            }


            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid.length;j++){

                }
            }
            return answer;
        }

        private boolean inRange(int[][] grid, int x, int y) {
            return 0<=x && x<grid.length && 0<=y && y<grid[0].length;
        }
    }

}
