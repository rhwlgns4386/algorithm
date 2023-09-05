package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N17684 {
    public static void main(String[] args) {

        for(int i=(int)(-2.2*100);i<2.2*100;i+=62){
            System.out.println(i/(double)100);
        }
//        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.solution("KAKAO")));
//        System.out.println(Arrays.toString(solution.solution("TOBEORNOTTOBEORTOBEORNOT")));
//        System.out.println(Arrays.toString(solution.solution("ABABABABABABABAB")));
    }

    static class Solution {
        public int[] solution(String msg) {
            HashMap<String,Integer> map = new HashMap<>();
            int count=1;
            for(int i=0;i<26;i++){
                char al= (char)('A'+i);
                map.put(al+"",count++);
            }
            List<Character> collect = msg.chars().mapToObj((i) -> (char) i).collect(Collectors.toList());
            LinkedList<Character> q = new LinkedList<>(collect);

            ArrayList<Integer> result = new ArrayList<>();
            while (!q.isEmpty()){
                StringBuilder sb = new StringBuilder();
                while (!q.isEmpty()){
                    sb.append(q.peek());
                    if(!map.containsKey(sb.toString())){
                        map.put(sb.toString(),count++);
                        sb.deleteCharAt(sb.length()-1);
                        result.add(map.get(sb.toString()));
                        break;
                    }else{
                        q.remove();
                        if(q.isEmpty()){
                            result.add(map.get(sb.toString()));
                        }
                    }
                }
            }

            return result.stream().mapToInt(i->i).toArray();
        }
    }
}
