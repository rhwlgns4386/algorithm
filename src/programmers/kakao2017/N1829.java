package programmers.kakao2017;

import java.util.LinkedList;

public class N1829 {

    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 1;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        int[][] groups=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0 && groups[i][j]==0){
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,bfs(picture,groups,numberOfArea,i,j));
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea-1;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int[][] picture, int[][] groups,int groupNum ,int x, int y) {
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        groups[x][y]=groupNum;

        int  cnt=1;
        while (!q.isEmpty()){
            Pair pair = q.remove();
            int px=pair.x;
            int py=pair.y;

            for(int i=0;i<4;i++){
                int nx=px+dx[i];
                int ny=py+dy[i];

                if(nx<0 || picture.length<=nx || ny<0 || picture[0].length<=ny) continue;

                if(picture[x][y]==picture[nx][ny] && groups[nx][ny]==0){
                    groups[nx][ny]=groupNum;
                    q.add(new Pair(nx,ny));
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
