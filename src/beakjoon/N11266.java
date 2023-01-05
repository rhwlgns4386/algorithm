package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11266 {
    static int count=0;
    static int[] discovered;
    static  ArrayList<Integer>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int e=Integer.parseInt(tokenizer.nextToken());

        nodes = (ArrayList<Integer>[]) new ArrayList[n + 1];
        TreeSet<Integer> set =new TreeSet<Integer>() ;
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
               dfs(set,i,true);
           }
       }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d\n",set.size()));
        for (Integer integer : set) {
            stringBuilder.append(String.format("%d ",integer));
        }

        System.out.println(stringBuilder);
    }

    private static int dfs(Set<Integer> s, int here, boolean isRoot) {
        discovered[here]=count++;
        int ret=discovered[here];

        int child=0;
        for (Integer edge : nodes[here]) {
            if(discovered[edge]==-1){
                ++child;
                int subtree=dfs(s,edge,false);

                if(!isRoot && subtree>=discovered[here]){
                    s.add(here);
                }

                ret=Math.min(subtree,ret);
            }
            else{
                ret=Math.min(ret,discovered[edge]);
            }
        }

        if(isRoot){
            if(child>=2){
                s.add(here);
            }
        }
        return ret;
    }
}
