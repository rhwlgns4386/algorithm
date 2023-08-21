package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N15900 {
    static ArrayList<Integer>[] a;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        a = new ArrayList[n + 1];

        for(int i = 1; i<= n; i++){
           a[i]=new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            a[start].add(end);
            a[end].add(start);
        }

        int count=bfs(1);
        if(count%2!=0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        boolean[] visit = new boolean[n + 1];
        visit[start]=true;

        int count=0;
        int level=0;
        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Integer node = q.remove();

                boolean isLeaf=true;
                for (Integer next:a[node]){
                    if(!visit[next]){
                        visit[next]=true;
                        q.add(next);
                        isLeaf=false;
                    }
                }
                if(isLeaf){
                    count+=level;
                }
            }
            level++;
        }

        return count;
    }
}
