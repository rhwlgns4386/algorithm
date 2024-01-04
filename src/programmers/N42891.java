package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class N42891 {
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int solution1 = solution.solution(new int[]{3, 1, 1, 1, 2, 4, 3}, 12);
            System.out.println(solution1);
            System.out.println( solution1== 6);

            int solution2 = solution.solution(new int[]{4, 3, 5, 6, 2}, 7);
            System.out.println(solution2);
            System.out.println( solution2== 3);

            int solution3 = solution.solution(new int[]{1,1,1,1}, 4);
            System.out.println(solution3);
            System.out.println( solution3== -1);

            int solution4 = solution.solution(new int[]{1,100}, 10);
            System.out.println(solution4);
            System.out.println( solution4== 2);

            int solution5 = solution.solution(new int[]{2}, 1);
            System.out.println(solution5);
            System.out.println( solution5== 1);
        }

        public int solution(int[] food_times, long k) {

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < food_times.length; i++) {
                int time = food_times[i];
                ArrayList<Integer> a = map.getOrDefault(time, new ArrayList<>());
                a.add(i + 1);
                map.put(time, a);
            }

            PriorityQueue<Integer> times = new PriorityQueue<>(map.keySet());

            long remainCount = food_times.length;
            long second=remainCount*(times.peek()-1);

            if(k<second){
                second=remainCount*(k/remainCount);
            }

            while (!times.isEmpty()) {
                if (k<remainCount+second) {
                    long index = k-second;
                    List<Integer> collect =
                            map.values().stream()
                                    .flatMap(arr -> arr.stream())
                                    .sorted()
                                    .collect(Collectors.toList());

                    return collect.get((int) index);
                } else {
                    int here = times.remove();
                    second+=remainCount;

                    remainCount -= map.get(here).size();
                    map.remove(here);

                    if (!times.isEmpty()) {
                        long count=times.peek()-here-1;
                        if(k<second+remainCount*(count)){
                            count = ((k - second) / remainCount);
                        }
                       second+=remainCount*(count);
                    }
                }
            }

            return -1;
        }
    }
}
