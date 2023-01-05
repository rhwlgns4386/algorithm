package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16935 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());
        int r=Integer.parseInt(stringTokenizer.nextToken());
        int[][] map=new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j <m ; j++) {
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        stringTokenizer=new StringTokenizer(in.readLine()," ");
        for(int i=0;i<r;i++){
            switch (Integer.parseInt(stringTokenizer.nextToken())){
                case 1:
                    map=operation1(map);
                    break;
                case 2:
                    map=operation2(map);
                    break;
                case 3:
                    map=operation3(map);
                    break;
                case 4:
                    map=operation4(map);
                    break;
                case 5:
                    map=operation5(map);
                    break;
                case 6:
                    map=operation6(map);
                    break;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[0].length ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] operation6(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[n][m];
        for(int i=0;i<n/2;i++){
            for (int j = 0; j < m/2; j++) {
                bmap[i+n/2][j]=map[i][j];
                bmap[i+n/2][j+m/2]=map[i+n/2][j];
                bmap[i][j+m/2]=map[i+n/2][j+m/2];
                bmap[i][j]=map[i][j+m/2];
            }
        }
        return bmap;
    }

    private static int[][] operation5(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[n][m];
        for(int i=0;i<n/2;i++){
            for (int j = 0; j < m/2; j++) {
                bmap[i][j+m/2]=map[i][j];
                bmap[i+n/2][j+m/2]=map[i][j+m/2];
                bmap[i+n/2][j]=map[i+n/2][j+m/2];
                bmap[i][j]=map[i+n/2][j];
            }
        }
        return bmap;
    }

    private static int[][] operation4(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                bmap[i][j]=map[j][m-i-1];
            }
        }
        return bmap;
    }


    private static int[][] operation3(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                bmap[i][j]=map[n-j-1][i];
            }
        }
        return bmap;
    }

    private static int[][] operation2(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                bmap[i][j]=map[i][m-j-1];
            }
        }
        return bmap;
    }

    private static int[][] operation1(int[][] map) {
        int n=map.length;
        int m=map[0].length;

        int[][] bmap=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                bmap[i][j]=map[n-i-1][j];
            }
        }
        return bmap;
    }
}
