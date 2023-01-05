package programmers;
import java.util.*;

public class N43163 {
    static class Pair {
        int node;
        int cnt;

        public Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        map.put(begin, words.length);

        Set<Integer>[] a = new HashSet[words.length + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashSet<>();
        }

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int iCh = chars[j];
                for (int k = 0; k < 26; k++) {
                    char tem = (char) ('a' + k);
                    chars[j] = tem;
                    String str = String.valueOf(chars);
                    if (map.containsKey(str)) {
                        a[i].add(map.get(str));
                        a[map.get(str)].add(i);
                    }
                }
                chars[j] = (char) iCh;
            }
        }

        if(map.containsKey(target)){
            answer=dfs(a,map.get(target),words.length);
        }
        return answer;
    }

    private static int dfs(Set<Integer>[] a, Integer target, Integer node) {
        boolean[] visit = new boolean[a.length];
        visit[node] = true;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));
        while (!q.isEmpty()) {
            Pair pair = q.remove();

            if (pair.node == target) {
                return pair.cnt;
            }

            for (Integer n : a[pair.node]) {
                if (!visit[n]) {
                    q.add(new Pair(n, pair.cnt + 1));
                    visit[n] = true;
                }
            }
        }

        return 0;
    }
}
