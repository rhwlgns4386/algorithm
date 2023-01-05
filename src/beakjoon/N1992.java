package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class N1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[][] map=new int[n][n];
        for(int i=0;i<n;i++){
            char[] chs=in.readLine().toCharArray();
            for(int j=0;j<n;j++){
                map[i][j]=Character.getNumericValue(chs[j]);
            }
        }
        StringBuilder sb=new StringBuilder();
        solution(map,sb,0,0,n);
        System.out.println(sb);
    }

    private static void solution(int[][] map, StringBuilder sb,int x,int y,int n) {
        boolean flag=false;
        for(int nx=0;nx<n;nx++){
            for(int ny=0;ny<n;ny++){
                if(map[x][y]!=map[x+nx][y+ny]){
                    flag=true;
                }
            }
        }
        if(!flag){
            sb.append(map[x][y]);
            return;
        }
        sb.append("(");
        int m=n/2;
        solution(map,sb,x,y,m);
        solution(map,sb,x,y+m,m);
        solution(map,sb,x+m,y,m);
        solution(map,sb,x+m,y+m,m);
        sb.append(")");
    }
}
