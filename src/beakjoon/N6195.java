package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class N6195 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());

        Queue<Long> q = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            q.add(Long.parseLong(in.readLine()));
        }

        long cent=0;
        while (q.size()>1){
            Long first = q.remove();
            Long second = q.remove();

            q.add((first+second));
            cent+=(first+second);
        }

        System.out.print(cent);
    }
}
