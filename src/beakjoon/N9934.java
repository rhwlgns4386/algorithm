package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N9934 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] a = new int[(1<<k)-1];
        for(int i=0;i<(1<<k)-1;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        bfs(a,0,(1<<k)-2);
    }

    private static void bfs(int[] a, int startL, int startR) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{startL,startR});

        int count=1;
        while (!q.isEmpty()){
            for(int i=0;i<count;i++){
                int[] node = q.remove();

                if(node[1]<node[0]) continue;

                int mid=(node[0]+node[1])/2;
                System.out.print(a[mid]+" ");

                q.add(new int[]{node[0],mid-1});
                q.add(new int[]{mid+1,node[1]});
            }
            System.out.println();
            count=count<<1;
        }
    }
}
