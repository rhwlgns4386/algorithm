package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1074 {
    public static final int[] dx={0,0,1,1};
    public static final int[] dy={0,1,0,1};
    public static int r;
    public static int c;
    public static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());

        r=Integer.parseInt(stringTokenizer.nextToken());
        c=Integer.parseInt(stringTokenizer.nextToken());


        solution(0,0,n);
    }

    private static void solution(int x, int y, int n) {
        if(n==1){
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx==r && ny==c){
                    System.out.println(cnt);
                    return;
                }
                cnt+=1;
            }
        }
        int m=n-1;
        int len=(1<<m);
        switch (getGroup(x,y,m)){
            case 0:
                solution(x,y,m);
                break;
            case 1:
                cnt+=len*len;
                solution(x,y+len,m);
                break;
            case 2:
                cnt+=2*len*len;
                solution(x+len,y,m);
                break;
            case 3:
                cnt+=3*len*len;
                solution(x+len,y+len,m);
                break;
        }
    }

    private static int getGroup(int x, int y,int n) {
        int len=(1<<n);
        boolean xFlag,yFlag;
        xFlag=yFlag=false;
        if(x+len<=r){
            xFlag=true;
        }
        if(y+len<=c){
            yFlag=true;
        }

        if(xFlag && yFlag){
            return 3;
        }
        else if(xFlag){
            return 2;
        }
        else if(yFlag){
            return 1;
        }
        else return 0;

    }
}
