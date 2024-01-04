package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N11666 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<int[]> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            a.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        a.sort((o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }else if(o1[0]==o2[0]){
                if(o1[1]<o2[1]){
                    return -1;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count=0;
        for(int i=0;i<a.size();i++){
            int[] here = a.get(i);

            int unlock=0;
            while (!pq.isEmpty()){
                if(here[0]<pq.peek()) break;

                if(pq.peek()+m <here[0]){
                    pq.remove();
                    continue;
                }else{
                    unlock=1;
                    pq.remove();
                    break;
                }
            }

            count+=unlock;
            pq.add(here[0]+here[1]);
        }

        System.out.println(count);
    }
}
