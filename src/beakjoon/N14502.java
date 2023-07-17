package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N14502 {

    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board=new int[N][M];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(go(board,0,0));
    }

    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    private static int go(int[][] board,int idx, int k) {
        if(k==3){
            int[][] temp = new int[N][M];
            LinkedList<int[]> q = new LinkedList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    temp[i][j]=board[i][j];
                    if(board[i][j]==2){
                        q.add(new int[]{i,j});
                    }
                }
            }

            while (!q.isEmpty()){
                int[] node = q.remove();
                int qx=node[0];
                int qy=node[1];

                for(int i=0;i<4;i++){
                    int nx=qx+dx[i];
                    int ny=qy+dy[i];

                    if(0<=nx && nx<N && 0<=ny && ny<M && temp[nx][ny]==0){
                        temp[nx][ny]=2;
                        q.add(new int[]{nx,ny});
                    }
                }
            }

            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(temp[i][j]==0) count++;
                }
            }

            return count;
        }
        if(idx==M*N) return 0;

        int result=0;
        result=Math.max(go(board,idx+1,k),result);

        int x=idx/M;
        int y=idx%M;
        if(board[x][y]==0){
            board[x][y]=1;
            result=Math.max(go(board,idx+1,k+1),result);
            board[x][y]=0;
        }

        return result;
    }
}
