package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N19542 {
    static ArrayList<Integer>[] a;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int s=Integer.parseInt(stringTokenizer.nextToken());
        int d=Integer.parseInt(stringTokenizer.nextToken());

        a = new ArrayList[n + 1];
        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            a[x].add(y);
            a[y].add(x);
        }

        check =new boolean[n+1];
        boolean[] visit = new boolean[n + 1];
        postorder(s,d,visit);
        visit=new boolean[n+1];
        System.out.println(getResult(s,visit)-1);
    }

    private static int getResult(int here, boolean[] visit) {

        visit[here]=true;

        int count=0;
        for(Integer i:a[here]){
            if(!visit[i] && !check[i]){
               count+=getResult(i,visit)+1;
            }
        }
        return count+1;
    }

    static int postorder(int here, int d, boolean[] visit){
        visit[here]=true;

        int count=0;
        for(Integer i:a[here]){
            if(!visit[i]){
                int before=postorder(i, d, visit);
                if(before<=d){
                    check[i]=true;
                }
                count=Math.max(before,count);
            }
        }

        return count+1;
    }
}
