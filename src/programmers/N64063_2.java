package programmers;

import java.util.HashMap;

public class N64063_2 {
    static class Solution{
        HashMap<Long, Long> hash;

        public long[] solution(long k, long[] room_number) {
            hash = new HashMap<>();
            long[] answer = new long[room_number.length];
            for(int i=0; i<room_number.length; i++){
                answer[i] = find(room_number[i])-1;
            }
            return answer;
        }

        long find(long number){
            if(!hash.containsKey(number)){
                hash.put(number, number+1);
                return number+1;
            }else{
                long temp = find(hash.get(number));
                hash.put(number, temp);
                return temp;
            }
        }
    }
}
