package groom.week4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N2 {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] map=new int[n][n];
        StringTokenizer st;
        LinkedList<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    q.add(i*n+j);
                }
            }
        }

        int cnt=0;
        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Integer index = q.remove();
                int x=index/n;
                int y=index%n;
                int flag=0;

                for(int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if(0<=nx&&0<=ny&&nx<n&&ny<n &&map[nx][ny]!=0){
                        flag=1;
                        map[nx][ny]-=1;
                        if(map[nx][ny]==0){
                            q.add(nx*n+ny);
                        }
                    }
                }

                if(flag==1){
                    q.add(index);
                }
            }
            cnt++;
        }
        System.out.println(cnt-1);
    }

}
