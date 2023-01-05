package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class N64064 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"*rodo", "*rodo", "******"}));
    }

    public static Set<Integer> set=new HashSet<>();
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        boolean[] visit=new boolean[user_id.length];
        go(user_id,banned_id,visit,0);
        return set.size();
    }

    private static void go(String[] user_id, String[] banned_id, boolean[] visit, int index) {
        if(index==banned_id.length){
            int ans=0;
            for(int i=0;i<visit.length;i++){
                if(visit[i]){
                    ans=ans*10+i;
                }
            }
            set.add(ans);
            return;
        }

        String pattern=banned_id[index].replace("*",".");
        for(int i=0;i<user_id.length;i++){
            if(!visit[i]&& Pattern.matches(pattern,user_id[i])){
                visit[i]=true;
                go(user_id,banned_id,visit,index+1);
                visit[i]=false;
            }
        }
    }
}
