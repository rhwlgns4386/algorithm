package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class N138476 {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<tangerine.length;i++){
            hashMap.put(tangerine[i],hashMap.getOrDefault(tangerine[i],0)+1);
        }

        List<Integer> collect = hashMap.entrySet().stream().map(e -> e.getValue()).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for(Integer i:collect){
            answer++;
            k-=i;
            if(k<=0){
                break;
            }
        }

        return answer;
    }
}
