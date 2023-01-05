package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16197 {
    public static int[][] map;
    public static int ans=11;
    public static int n,m;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={-0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        n=Integer.parseInt(stringTokenizer.nextToken());
        m=Integer.parseInt(stringTokenizer.nextToken());
        map=new int[n][m];

        int x1,x2,y1,y2;
        x1=x2=y1=y2=-1;
        for(int i=0; i<n;i++){
            char[] chars = in.readLine().toCharArray();
            for(int j=0;j<m;j++){
                if(chars[j]=='o'){
                    map[i][j]=1;
                    if(x1==-1){
                        x1=i;
                        y1=j;
                    }
                    else {
                        x2=i;
                        y2=j;
                    }
                }
                else if(chars[j]=='#'){
                    map[i][j]=2;
                }
            }
        }
        go(x1,y1,x2,y2,0);
        System.out.println(ans!=11?ans:-1);
    }

    private static void go(int x1, int y1, int x2, int y2,int cnt) {
        if(cnt==11) return;
        boolean coin1Check=false;
        boolean coin2Check=false;
        if( x1<0 || y1<0 ||x1>= n || y1>=m) coin1Check=true;
        if( x2<0 || y2<0 ||x2>= n || y2>=m) coin2Check=true;
        if(coin1Check&&coin2Check) return;
        if(coin1Check^coin2Check) ans=Math.min(ans,cnt);
        for (int k=0; k<4; k++){
            int nx1 = x1+dx[k];
            int ny1 = y1+dy[k];
            int nx2 = x2+dx[k];
            int ny2 = y2+dy[k];
            if (0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && map[nx1][ny1] == 2) {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && map[nx2][ny2] == 2) {
                nx2 = x2;
                ny2 = y2;
            }
            go(nx1,ny1,nx2,ny2,cnt+1);
        }
    }
}
