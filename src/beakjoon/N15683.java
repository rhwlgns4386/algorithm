package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15683 {
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int n,m;
    static  ArrayList<Integer> a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        a = new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0 &&map[i][j]!=6){
                    a.add(i*m+j);
                }
            }
        }


        System.out.println(go(map,0));
    }

    private static int go(int[][] map,int index) {

        if(index==a.size()){
            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0) cnt++;
                }
            }
            return cnt;
        }

        int x=a.get(index)/m;
        int y=a.get(index)%m;

        int number=map[x][y];
        int ans=Integer.MAX_VALUE;

        if(number==5){
            draw(map,x,y,0,number,-1);
            ans=Math.min(go(map,index+1),ans);
            draw(map, x,y,0,number,1);
        }
        else {
            for(int i=0;i<4;i++){
                draw(map,x,y,i,number,-1);
                ans=Math.min(go(map,index+1),ans);
                draw(map, x,y,i,number,1);
            }
        }
        return ans;
    }

    private static void draw(int[][] map, int x, int y, int i, int number, int check) {
        switch (number){
            case 1:
                fill(map,x,y,i,check);
                break;
            case 2:
                int sum=1;
                if(i==1 ||i==3){
                    sum=-1;
                }
                fill(map,x,y,i,check);
                fill(map,x,y,i+sum,check);
                break;
            case 3:
                if(i==2){
                    fill(map,x,y,i,check);
                    fill(map,x,y,0,check);
                }else if(i==0){
                    fill(map,x,y,i,check);
                    fill(map,x,y,3,check);
                }else if(i==3){
                    fill(map,x,y,i,check);
                    fill(map,x,y,1,check);
                }else{
                    fill(map,x,y,i,check);
                    fill(map,x,y,2,check);
                }

                break;
            case 4:
                fill(map,x,y,i,check);
                fill(map,x,y,(i+1)%4,check);
                fill(map,x,y,(i+2)%4,check);
                break;
            case 5:
                fill(map,x,y,0,check);
                fill(map,x,y,1,check);
                fill(map,x,y,2,check);
                fill(map,x,y,3,check);
                break;
        }
    }

    private static void fill(int[][] map, int x, int y, int i, int check) {
        while (true){
            int nx=x+dx[i];
            int ny=y+dy[i];
            x=nx;
            y=ny;
            if(nx<0 || n<=nx || ny<0 || m<=ny || map[nx][ny]==6) break;
            if(0<map[nx][ny]) continue;
            map[x][y]+=check;
        }
    }
}
