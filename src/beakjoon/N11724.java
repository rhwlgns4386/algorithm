import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        boolean[] visit=new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(in.readLine(), " ");
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            if (!a[node1].contains(node2)) {
                a[node1].add(node2);
                a[node2].add(node1);
            }
        }

        Queue<Integer> q=new LinkedList<>();
        int count=0;

        for(int i=1;i<=n;i++){
            if(!visit[i]){
                q.add(i);
                visit[i]=true;
                count+=1;
            }

            while (!q.isEmpty()){
                for (Integer integer : a[q.poll()]) {
                    if(!visit[integer]){
                        q.add(integer);
                        visit[integer]=true;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
