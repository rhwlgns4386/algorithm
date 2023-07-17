package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N14948_2 {

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

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int lo=-1;
        int hi=(int)Math.pow(10,9);
        while (lo+1<hi){
            int mid=(lo+hi)/2;
            if(bfs(0,0,mid)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
        return hi;
    }

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    private static boolean bfs(int startX, int startY, int mid) {
        if(map[startX][startY]>mid) return false;
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(startX,startY,0));

        boolean visit[][][]=new boolean[n][m][2];
        visit[startX][startY][0]=true;
        while (!q.isEmpty()){
            Node node = q.remove();
            int x=node.x;
            int y=node.y;
            int jump= node.jump;

            if(x==n-1&&y==m-1){
                return true;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(inRange(nx,ny)){
                    if(map[nx][ny]<=mid){
                        if(!visit[nx][ny][jump]){
                            q.add(new Node(nx,ny,jump));
                            visit[nx][ny][jump]=true;
                        }
                    } else if(jump==0){
                        int nnx=nx+dx[i];
                        int nny=ny+dy[i];
                        if(inRange(nnx,nny) && map[nnx][nny]<=mid &&!visit[nnx][nny][1]){
                            q.add(new Node(nnx,nny,1));
                            visit[nnx][nny][1]=true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean inRange(int x, int y) {
        return 0<=x && x<n && 0<=y && y<m;
    }

    static class Node{
        int x;
        int y;
        int jump;

        public Node(int x, int y,int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
}
