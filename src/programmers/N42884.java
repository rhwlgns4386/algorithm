package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class N42884 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,1}, {0,1}, {1,2}}));
    }
    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });

        int cam = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }
}
