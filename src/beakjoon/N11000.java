package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11000 {
    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            int compare = Integer.compare(this.first, o.first);
            if(compare==0){
                compare=Integer.compare(this.second,o.second);
            }
            return compare;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        Pair[] a=new Pair[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            a[i]=(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Arrays.sort(a);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(a[0].second);
        for(int i=1;i<n;i++){
            Pair pair = a[i];
            if(pq.peek()<=pair.first){
                pq.remove();
            }
            pq.add(pair.second);
        }

        System.out.println(pq.size());
    }
}
