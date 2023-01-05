package programmers;

import java.util.*;

public class N12927 {
    public static void main(String[] args) {
        System.out.println(solution(2,new int[]{2, 1, 2}));
    }
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<works.length;i++){
            q.add(works[i]);
        }

        for(int i=0;i<n;i++){
            Integer work = q.poll();
            if(0<work){
                q.add(work-1);
            }else{
                q.add(work);
            }
        }

        for(int i=0;i<works.length;i++){
            Integer work = q.poll();
            answer+=(work*work);
        }
        return answer;
    }
}
