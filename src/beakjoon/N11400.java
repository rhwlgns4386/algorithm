package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11400 {
    static int count=0;
    static int[] discovered;
    static  ArrayList<Integer>[] nodes;
    static class Edge implements Comparable<Edge>{
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.from<o.from) return -1;
            else if(this.from==o.from){
                if(this.to<o.to) return -1;
                else if(this.to==o.to) return 0;
                else return 1;
            }
            else return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int e=Integer.parseInt(tokenizer.nextToken());

        nodes = (ArrayList<Integer>[]) new ArrayList[n + 1];
        Queue<Edge> ans =new PriorityQueue<>() ;
        discovered=new int[n+1];

        for(int i=1;i<=n;i++){
            nodes[i]=new ArrayList<>();
            discovered[i]=-1;
        }

        for(int i=0;i<e;i++){
            tokenizer=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(tokenizer.nextToken());
            int to=Integer.parseInt(tokenizer.nextToken());
            nodes[from].add(to);
            nodes[to].add(from);
        }

        for(int i=1;i<=n;i++){
            if(discovered[i]==-1){
                dfs(ans,0,i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d\n",ans.size()));
        while (!ans.isEmpty()){
            Edge edge = ans.remove();
            stringBuilder.append(String.format("%d %d\n",edge.from,edge.to));
        }
        System.out.println(stringBuilder);
    }

    private static int dfs(Queue<Edge> a,int parent, int here) {
        discovered[here]=count++;
        int ret=discovered[here];

        for (Integer edge : nodes[here]) {
            if(parent==edge) continue;
            if(discovered[edge]==-1){
                int subtree=dfs(a,here,edge);


                if(subtree>discovered[here]){
                   a.add(new Edge(Math.min(here,edge),Math.max(here,edge)));
                }

                ret=Math.min(subtree,ret);
            }
            else{
                ret=Math.min(ret,discovered[edge]);
            }
        }

        return ret;
    }
}
