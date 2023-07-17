package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N13023 {
    static boolean[] visit;
    private static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        a = new ArrayList[n];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            a[start].add(end);
            a[end].add(start);
        }

        int result=0;
        for(int i=0;i<n;i++){
            visit=new boolean[n];
            if(dfs(i,4)){
                result=1;
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean dfs(int start,int count) {
        visit[start]=true;
        if(count==0){
            return true;
        }

        for(Integer next:a[start]){
            if(!visit[next]){
                if(dfs(next,count-1))return true;
                visit[next]=false;
            }
        }
        return false;
    }
}
