package programmers;

import java.util.*;

public class N42628 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Comparator.reverseOrder());
        for (String s : operations) {
            String[] split = s.split(" ");
            if (split[0].equals("I")) {
                int i = Integer.parseInt(split[1]);
                q.add(i);
                rq.add(i);
            } else {
                if (Integer.parseInt(split[1]) == 1) {
                    Integer poll = rq.poll();
                    if(poll!=null){
                        q.remove(poll);
                    }

                } else {
                    Integer poll = q.poll();
                    if(poll!=null){

                        rq.remove(poll);
                    }
                }
            }
        }

        if(rq.isEmpty() && q.isEmpty()){
            return answer;
        }
        else {
            answer[0] = rq.poll();
            answer[1] = q.poll();
        }

        return answer;
    }
}
