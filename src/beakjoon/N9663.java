package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9663 {
    static boolean[][] a = new boolean[15][15];
    public static boolean [] colCheck;
    public static boolean [] digCheck;
    public static boolean [] dig2Check;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());
        colCheck =new boolean[15];
        digCheck=new boolean[40];
        dig2Check=new boolean[40];
        System.out.println(calc(0));
    }

    private static int calc(int row) {
        if(row==n) return 1;
        int ans=0;
        for(int col=0;col<n;col++){
            if(check(row,col)){
                colCheck[col]=true;
                digCheck[row+col]=true;
                dig2Check[row-col+n]=true;
                ans+=calc(row+1);
                colCheck[col]=false;
                digCheck[row+col]=false;
                dig2Check[row-col+n]=false;
            }
        }
        return ans;
    }

    static boolean check(int row, int col) {
        // |
        if (colCheck[col]) {
            return false;
        }
        // 왼쪽 위 대각선
        if (digCheck[row+col]) {
            return false;
        }
        // /
        if (dig2Check[row-col+n]) {
            return false;
        }
        return true;
    }
}
