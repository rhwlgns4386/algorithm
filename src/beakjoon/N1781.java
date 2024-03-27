package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        int maxDeadline=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int deadline=Integer.parseInt(st.nextToken());
            int cup=Integer.parseInt(st.nextToken());
            pq.add(new Pair(deadline,cup));
            maxDeadline=Math.max(maxDeadline,deadline);
        }

        int result=0;

        PriorityQueue<Integer> output = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=maxDeadline;1<=i;i--){
            while (!pq.isEmpty()&&i<=pq.peek().first)output.add(pq.remove().second);
            if(!output.isEmpty()){
                result+=output.remove();
            }
        }
        System.out.println(result);
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if(first>o.first){
                return -1;
            }else if(first==o.first){
                if(o.second<second){
                    return -1;
                }else{
                    return 1;
                }
            }else {
                return 1;
            }
        }
    }
}
