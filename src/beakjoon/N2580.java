package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2580 {
    static boolean[][] rowCheck=new boolean[9][10];
    static boolean[][] colCheck=new boolean[9][10];
    static boolean[][] boxCheck=new boolean[9][10];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int [][] map=new int[9][9];

        for(int i=0;i<9;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
            for(int j=0;j<9;j++){
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                if(map[i][j]!=0){
                    rowCheck[i][map[i][j]]=colCheck[j][map[i][j]]=boxCheck[square(i,j)][map[i][j]]=true;
                }
            }
        }
        go(map,0);
    }

    private static boolean go(int[][] map, int z) {
        if(z==81){
            for (int i = 0; i <9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }
        int x=z/9;
        int y=z%9;
        if(map[x][y]!=0) return go(map,z+1);
        for(int i=1;i<=9;i++){
            if(!rowCheck[x][i] && !colCheck[y][i] && !boxCheck[square(x,y)][i]){
                rowCheck[x][i]=colCheck[y][i]=boxCheck[square(x,y)][i]=true;
                map[x][y]=i;
                if(go(map,z+1)){
                    return true;
                }
                map[x][y]=0;
                rowCheck[x][i]=colCheck[y][i]=boxCheck[square(x,y)][i]=false;
            }
        }
        return false;
    }

    private static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }
}
