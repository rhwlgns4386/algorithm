package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N14948 {

    private static int[][] map;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i< n; i++){
            st=new StringTokenizer(in.readLine());
            for(int j = 0; j< m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0,0));
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    private static int bfs(int startX, int startY) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(startX,startY,map[startX][startY],0));

        int[][][] visit=new int[n][m][2];
        int initNum=(int)Math.pow(10,9)+1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visit[i][j][0]=initNum;
                visit[i][j][1]=initNum;
            }
        }
        visit[startX][startY][0]=map[startX][startY];

        while (!q.isEmpty()){
            Node node = q.remove();
            int x=node.x;
            int y= node.y;
            int jump= node.jump;
            int max= node.max;

            if(x==n-1 && y==m-1){
                continue;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(inRange(nx,ny)){
                    if(visit[nx][ny][jump]>max){
                        int maxValue=Math.max(max,map[nx][ny]);
                        q.add(new Node(nx,ny,maxValue,node.jump));
                        visit[nx][ny][jump]=maxValue;
                    }
                    if(jump==0){
                        int nnx=nx+dx[i];
                        int nny=ny+dy[i];
                        if(inRange(nnx,nny) && visit[nnx][nny][1]>max){
                            int maxValue=Math.max(map[nnx][nny],max);
                            q.add(new Node(nnx,nny,maxValue,1));
                            visit[nnx][nny][1]=maxValue;
                        }
                    }
                }
            }
        }

        return Math.min(visit[n-1][m-1][0],visit[n-1][m-1][1]);
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
    }

    static class Node{
        int x;
        int y;
        int max;
        int jump;

        public Node(int x, int y, int max, int jump) {
            this.x = x;
            this.y = y;
            this.max = max;
            this.jump = jump;
        }
    }
}
