package programmers.Kakao2022BlindRecruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N72411 {
    static class Pair implements Comparable<Pair>{
        int word;
        int count;

        public Pair(int word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.count>o.count){
                return -1;
            }
            else if(this.count==o.count){
                return 0;
            }
            else return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4})));
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int[] words=new int[orders.length];
        for(int i=0;i<orders.length;i++){
            for(char c:orders[i].toCharArray()){
                words[i]|=(1<<(c-'A'));
            }
        }
        HashMap<Integer, PriorityQueue<Pair>> map=new HashMap<>();
        for(int i=2;i<=10;i++){
            map.put(i,new PriorityQueue<>());
        }

        for (int i=0;i<(1<<26)-1;i++){
            int bitCount = Integer.bitCount(i);
            if(bitCount<=1 ||10<bitCount) continue;
            int count=0;
            for(int j=0;j<orders.length;j++){
                if((words[j]&i)==i){
                    count++;
                }
            }
            if(count>1){
                map.get(bitCount).add(new Pair(i,count));
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int count=0;
            PriorityQueue<Pair> pairs = map.get(course[i]);

            while (!pairs.isEmpty()&&pairs.peek().count>=count){
                int word=pairs.peek().word;
                int pairCount=pairs.peek().count;
                pairs.remove();

                a.add(word);
                count=pairCount;
            }

        }

        answer=new String[a.size()];
        for(int i=0;i<a.size();i++){
            answer[i]=makeWord(a.get(i));
        }
        Arrays.sort(answer);
        return answer;
    }

    public static String makeWord(int i){
        StringBuffer sb = new StringBuffer();
        for(int k=0;k<26;k++){
            if((i&(1<<k))>0) {
                int word=k+'A';
                sb.append((char)word);
            }
        }
        return sb.toString();
    }
}
