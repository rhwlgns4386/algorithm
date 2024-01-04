package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class N60060 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
    }

    static class Solution {
        public int example(int input){
            if(input==0){
                return 1;
            }
            if(input==1){
                return 2;
            }
            return -1;
        }

        public int[] solution(String[] words, String[] queries) {

            Node front = new Node();
            Node back = new Node();
            for (int i = 0; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                front.add(word.toString());
                back.add(word.reverse().toString());
            }

            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                StringBuilder query = new StringBuilder(queries[i]);
                if (query.charAt(0) == '?') {
                    answer[i] = back.find(query.reverse().toString(), 0);
                } else {
                    answer[i] = front.find(query.toString(), 0);
                }
            }
            return answer;
        }

        static class Node {
            private HashMap<Integer, Integer> lenMap = new HashMap<>();
            private Node[] child = new Node[26];

            public void add(String word) {
                Node node = this;
                int len = word.length();
                lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (node.child[idx] == null) {
                        node.child[idx] = new Node();
                    }

                    node = node.child[idx];
                    node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
                }
            }

            public int find(String str, int i) {
                if (str.charAt(i) == '?') {
                    return lenMap.getOrDefault(str.length(), 0);
                }

                int idx = str.charAt(i) - 'a';
                return child[idx] == null ? 0 : child[idx].find(str, i + 1);
            }
        }
    }
}
