package beakjoon;

import java.io.*;
import java.util.*;

public class N2150 {
    static ArrayList<Integer>[] a;
    static int[] discovered;
    static int[] sccId;
    static int sccCount,vertexCount;
    static Stack<Integer> st=new Stack<>();
    static List<Queue<Integer>> result=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int v=Integer.parseInt(tokenizer.nextToken());
        int e=Integer.parseInt(tokenizer.nextToken());

        a = (ArrayList<Integer>[]) new ArrayList[v + 1];
        discovered=new int[v+1];
        sccId=new int[v+1];

        sccCount=vertexCount=0;

        Arrays.fill(discovered,-1);
        Arrays.fill(sccId,-1);

        for(int i=1;i<=v;i++){
            a[i]=new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
           tokenizer= new StringTokenizer(in.readLine());
           int from=Integer.parseInt(tokenizer.nextToken());
           int to=Integer.parseInt(tokenizer.nextToken());

           a[from].add(to);
        }


        for(int i=1; i<v+1; i++) {
            if(discovered[i] == -1) {
                scc(i);
            }
        }

        System.out.println(sccCount);
        Collections.sort(result, (o1,o2) -> o1.peek()-o2.peek());
        StringBuilder sb = new StringBuilder();
        for(Queue<Integer> q : result ) {
            while(!q.isEmpty())	{
                sb.append(q.poll()+" ");
            }
            sb.append(-1+"\n");
        }
        System.out.println(sb.toString());

    }

    private static int scc(int here) {
        int ret=discovered[here]=vertexCount++;
        st.add(here);

        for (Integer there : a[here]) {
            if(discovered[there]==-1){
                int subTree=scc(there);
                ret=Math.min(ret,subTree);
            }
            else if(sccId[there]==-1){
                ret=Math.min(ret,discovered[there]);
            }
        }

        if(ret==discovered[here]){
            PriorityQueue<Integer> q = new PriorityQueue<>();
            while (true){
                Integer t = st.pop();
                sccId[t]=sccCount;
                q.add(t);
                if(t==here) break;
            }
            result.add(q);
            ++sccCount;
        }
        return ret;
    }
}
