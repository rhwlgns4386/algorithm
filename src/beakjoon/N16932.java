package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class N16932 {
    static int[][] map;
    static int[][] group;
    static int[] cnt = new int[1000000];
    static int N;
    static int M;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (group[i][j] == 0 && map[i][j]==1) {
                    int count=dfs(i, j, groupNum);
                    cnt[groupNum]=count;
                    groupNum++;
                }
            }
        }

        boolean[] visit=new boolean[groupNum+1];
        int ans=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    int tem=0;
                    for (int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx<0 || N<=nx ||ny<0 || M<=ny || group[nx][ny]==0 || visit[group[nx][ny]]) continue;

                        tem+=cnt[group[nx][ny]];
                        visit[group[nx][ny]]=true;
                    }
                    ans=Math.max(tem+1,ans);

                    for (int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx<0 || N<=nx ||ny<0 || M<=ny) continue;

                        visit[group[nx][ny]]=false;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int x, int y, int groupNum) {
        group[x][y]=groupNum;
        int count=1;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0 || N<=nx ||ny<0 || M<=ny || group[nx][ny]!=0 ||map[nx][ny]==0) continue;
            count+=dfs(nx,ny,groupNum);
        }
        return count;
    }
}
