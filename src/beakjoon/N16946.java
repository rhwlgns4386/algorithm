package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N16946 {

    static int[][] map;
    static int[][] group;
    static boolean[][] visit;
    static ArrayList<Integer> groupCntList;

    static final int[] dx={0,0,-1,1};
    static final int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());

        map=new int[n][m];
        group=new int[n][m];
        visit=new boolean[n][m];
        groupCntList = new ArrayList<>();

        for(int i=0;i<n;i++){
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j]=Character.getNumericValue(chars[j]);
                group[i][j]=-1;
            }
        }

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0 && !visit[i][j]){
                    bfs(n,m,i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    out.write("0");
                }else {
                    HashSet<Integer> hashSet = new HashSet<>();
                    for(int idx=0;idx<4;idx++){
                        int nx=i+dx[idx];
                        int ny=j+dy[idx];

                        if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==0){
                            int g = group[nx][ny];
                            hashSet.add(g);
                        }
                    }

                    int ans=1;
                    for (Integer integer : hashSet) {
                        ans+=groupCntList.get(integer);
                    }

                    out.write(String.valueOf(ans%10));

                }
            }
            out.write("\n");
        }

        out.flush();
        out.close();
        in.close();
    }

    private static void bfs(int n, int m, int i, int j) {
        int cnt=1;
        int g=groupCntList.size();
        LinkedList<Integer> q = new LinkedList<>();
        visit[i][j]=true;
        group[i][j]=g;
        q.add(i); q.add(j);
        while (!q.isEmpty()){
            Integer x = q.remove();
            Integer y = q.remove();
            for(int idx=0;idx<4;idx++){
                int nx=x+dx[idx];
                int ny=y+dy[idx];

                if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==0 && !visit[nx][ny]){
                    group[nx][ny]=g;
                    visit[nx][ny]=true;
                    q.add(nx); q.add(ny);
                    cnt+=1;
                }
            }
        }
        groupCntList.add(cnt);
    }
}
