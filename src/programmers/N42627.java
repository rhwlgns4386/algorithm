package programmers;

import java.util.PriorityQueue;

public class N42627 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
    static class Pair{
        int start;
        int time;
        int end;

        public Pair(int start, int time) {
            this.start = start;
            this.time = time;
            this.end=start+time;
        }

    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int[] job:jobs){
            q.add(new Pair(job[0],job[1]));
        }

        int totalSum=0;
        while (!q.isEmpty()){
            Pair pair = q.remove();
            int endTime=totalSum+pair.time-pair.start;
            totalSum+=endTime;
        }
        return totalSum/jobs.length;
    }
}
