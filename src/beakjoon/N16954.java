package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class N16954 {
    static int[][] wallMap;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        wallMap=new int[8][8];
        for(int i=0;i<8;i++){
            String s = in.readLine();
            for(int j=0;j<8;j++){
                if(s.charAt(j)=='#'){
                    wallMap[i][j]=1;
                }
            }
        }

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{7,0});

        int result=1;
        boolean[][] visit=new boolean[8][8];
        for(int i=0;i<9;i++){

            bfs(q,visit);
            if(q.isEmpty()){
                result=0;
                break;
            }
            wallMap=downWall(wallMap);
        }

        System.out.println(result);
    }

    static int[] dx={0,0,1,-1,-1,-1,1,1};
    static int[] dy={1,-1,0,0,1,-1,1,-1};

    private static void bfs(LinkedList<int[]> q,boolean[][] visit) {
        int size = q.size();

        while (size-->0){
            int[] node = q.remove();
            int x = node[0];
            int y = node[1];

            if(wallMap[x][y]==1) continue;

            visit[x][y]=true;
            for(int i=0;i<8;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx && nx<8 && 0<=ny && ny<8 && wallMap[nx][ny]==0&&!visit[nx][ny]){
                    q.add(new int[]{nx,ny});
                }
            }

            q.add(new int[]{x,y});
        }
    }

    private static int[][] downWall(int[][] wallMap) {
        int[][] copyWallMap = new int[8][8];
        for(int i=0;i<7;i++){
            for(int j=0;j<8;j++){
                if(wallMap[i][j]==1){
                    copyWallMap[i+1][j]=1;
                }
            }
        }
        return copyWallMap;
    }
}
