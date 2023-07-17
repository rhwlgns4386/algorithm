package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1325 {

    private static ArrayList<Integer>[] a;
    private static boolean[] visit;
    static int[] hackingCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        a = new ArrayList[n + 1];
        for(int i=1;i<n+1;i++){
            a[i]=new ArrayList<Integer>();
        }


        for(int i=0;i<m;i++){
            String[] fromTo = in.readLine().split(" ");
            int start=Integer.parseInt(fromTo[0]);
            int end=Integer.parseInt(fromTo[1]);

            a[start].add(end);
        }



        hackingCnt=new int[n+1];
        for(int i=1;i<n+1;i++){
            visit=new boolean[n+1];
            bfs(i);

        }

        int max=0;
        for(int i=1;i<n+1;i++){
            max=Math.max(hackingCnt[i],max);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n+1;i++){
            if(hackingCnt[i]==max){
                sb.append(i+" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start]=true;

        while (!q.isEmpty()){
            Integer node = q.remove();

            for(Integer next:a[node]){
                if(!visit[next]){
                    q.add(next);
                    visit[next]=true;
                    hackingCnt[next]++;
                }
            }
        }
    }
}