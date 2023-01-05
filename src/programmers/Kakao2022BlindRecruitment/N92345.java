package programmers.Kakao2022BlindRecruitment;

import java.util.Arrays;

public class N92345 {
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) {
        int[][] board={{1, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}};
        int[] aloc={0,0};
        int[] bloc={3,3};
        System.out.println(solution(board,aloc,bloc));
    }

    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        int x1=aloc[0];
        int y1=aloc[1];
        int x2=bloc[0];
        int y2=bloc[1];
        return Math.min(go(board, x1, y1, x2, y2, true, 0), go(board, x1, y1, x2, y2, false, 0));
    }

    private static int go(int[][] board, int x, int y, int x2, int y2, boolean check, int cnt) {
        if(checking(board,x,y)){
            if(check){
                return 25;
            }
            return cnt;
        }

        int ans=Integer.MIN_VALUE;
        if(check){
            ans=Integer.MAX_VALUE;
        }

        board[x][y]=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 ||board.length<=nx || ny<0 || board[0].length<=ny || board[nx][ny]==0) continue;

            if(check){
                ans=Math.min(go(board,x2,y2,nx,ny,false,cnt+1),ans);
            }
            else {
                ans=Math.max(go(board,x2,y2,nx,ny,true,cnt+1),ans);
            }
        }
        board[x][y]=1;
        return ans;
    }

    private static boolean checking(int[][] board, int x, int y) {
        if(board[x][y]==0) return true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 ||board.length<=nx || ny<0 || board[0].length<=ny || board[nx][ny]==0) continue;

            return false;
        }
        return true;
    }
}
