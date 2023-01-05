package beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class N11658 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());

        long[][] map=new long[n+1][n+1];
        long[][] tree=new long[n+1][n+1];
        for(int i=1;i<=n;i++){
            tokenizer=new StringTokenizer(in.readLine()," ");
            for(int j=1;j<=n;j++){
                map[i][j]=Long.parseLong(tokenizer.nextToken());
                update(tree,i,j,map[i][j]);
            }
        }

        while (m-->0){
            tokenizer=new StringTokenizer(in.readLine()," ");
            int w=Integer.parseInt(tokenizer.nextToken());
            if(w==0){
                int x=Integer.parseInt(tokenizer.nextToken());
                int y=Integer.parseInt(tokenizer.nextToken());
                int c=Integer.parseInt(tokenizer.nextToken());
                update(tree,x,y,c-map[x][y]);
                map[x][y]=c;

            }else {
                int x1=Integer.parseInt(tokenizer.nextToken());
                int y1=Integer.parseInt(tokenizer.nextToken());
                int x2=Integer.parseInt(tokenizer.nextToken());
                int y2=Integer.parseInt(tokenizer.nextToken());
                out.write(sum(tree,x2,y2)-sum(tree,x1-1,y2)-sum(tree,x2,y1-1)+sum(tree,x1-1,y1-1)+"\n");
            }
        }

        out.flush();
        out.close();
        in.close();
    }

    private static long sum(long[][] tree, int x, int y) {
        long ans=0;
        for(int i=x;i>0;i-=i&-i){
            for(int j=y;j>0;j-=j&-j){
                ans+=tree[i][j];
            }
        }
        return ans;
    }

    private static void update(long[][] tree, int x, int y, long diff) {
        for(int i=x;i<=tree.length;i+=i&-i){
            for(int j=y;j<=tree.length;j+=j&-j){
                tree[i][j]+=diff;
            }
        }
    }
}
