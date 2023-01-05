package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");

        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        int[] ind=new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            tokenizer=new StringTokenizer(in.readLine()," ");
            int x=Integer.parseInt(tokenizer.nextToken());
            int y=Integer.parseInt(tokenizer.nextToken());

            a[x].add(y);
            ind[y]+=1;
        }

        for(int i=1;i<=n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            Integer x = q.remove();
            System.out.print(x+" ");
            ArrayList<Integer> edges = a[x];

            for(Integer i:edges){
                ind[i]-=1;
                if(ind[i]==0){
                    q.add(i);
                }
            }
        }
        System.out.println();
    }
}
