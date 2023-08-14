package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N24230 {
    static int count=0;
    private static ArrayList<ArrayList<Integer>> a;
    private static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        colors = new int[n + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=1;i<n+1;i++){
            colors[i]=Integer.parseInt(st.nextToken());
        }

        a = new ArrayList<>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            a.get(start).add(end);
            a.get(end).add(start);
        }

        boolean[] visit = new boolean[n + 1];
        bfs(visit,1,0);
        System.out.println(count);
    }

    private static void bfs(boolean[] visit, int here, int color) {
        visit[here]=true;
        int nextColor=color;
        if(colors[here]!=0 && color!=colors[here]){
            nextColor=colors[here];
            count++;
        }
        for(Integer next:a.get(here)){
            if(!visit[next]){
                visit[next]=true;
                bfs(visit,next,nextColor);
            }
        }
    }
}
