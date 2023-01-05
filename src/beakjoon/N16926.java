package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[n][m];


        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int groupn=Math.min(n,m)/2;
        ArrayList<ArrayList<Integer>> groups=new ArrayList<>();
        for (int k = 0; k < groupn; k++) {
            ArrayList<Integer> group=new ArrayList<>();
            for (int j = k; j < m-k; j++) {
                group.add(map[k][j]);
            }
            for (int i = k+1; i < n-k-1; i++) {
                group.add(map[i][m-k-1]);
            }
            for (int j=m-k-1; j>k; j--) {
                group.add(map[n-k-1][j]);
            }
            for (int i=n-k-1; i>k; i--) {
                group.add(map[i][k]);
            }
            groups.add(group);
        }

        for (int k = 0; k <groupn; k++) {
            ArrayList<Integer> group=groups.get(k);
            int len=group.size();
            int index=r%len;
            for (int j = k; j < m-k; j++,index=(index+1)%len) {
                map[k][j]=group.get(index);
            }
            for (int i = k+1; i < n-k-1; i++,index=(index+1)%len) {
                map[i][m-k-1]=group.get(index);
            }
            for (int j=m-k-1; j>k; j--,index=(index+1)%len) {
                map[n-k-1][j]=group.get(index);
            }
            for (int i=n-k-1; i>k; i--,index=(index+1)%len) {
                map[i][k]=group.get(index);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
