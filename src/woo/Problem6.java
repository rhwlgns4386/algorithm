package woo;

import java.util.*;

public class Problem6 {
    public static class NickNamePattern implements Comparable<NickNamePattern> {
        String pattern;
        int index;

        public NickNamePattern(String pattern, int index) {
            this.pattern = pattern;
            this.index = index;
        }

        @Override
        public int compareTo(NickNamePattern target) {
            char[] thisChars = this.pattern.toCharArray();
            char[] targetChars = target.pattern.toCharArray();
            if(thisChars[0]<targetChars[0]) return -1;
            else if(thisChars[0]==targetChars[0]){
                if(thisChars[1]<targetChars[1]) return -1;
                else if(thisChars[1]==targetChars[1])return 0;
                else return 1;
            }else return 1;
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        HashSet<String> patternSet;
        PriorityQueue<NickNamePattern> nickNamePatternQueue = new PriorityQueue<>();

        for(int i=0;i<forms.size();i++){
            patternSet=new HashSet<>();
            List<String> form = forms.get(i);
            String nickName = form.get(1);
            for(int j=2;j<=nickName.length();j++){
                patternSet.add(nickName.substring(j-2,j));
            }
            for(String str:patternSet){
                nickNamePatternQueue.add(new NickNamePattern(str,i));
            }
        }

        HashSet<String> resultSet = new HashSet<>();
        NickNamePattern checkNickNamePattern = nickNamePatternQueue.remove();

        while (!nickNamePatternQueue.isEmpty()){
            NickNamePattern nickNamePattern = nickNamePatternQueue.remove();
            if(nickNamePattern.pattern.equals(checkNickNamePattern.pattern)){
                resultSet.add(forms.get(nickNamePattern.index).get(0));
                resultSet.add(forms.get(checkNickNamePattern.index).get(0));
            }
            checkNickNamePattern = nickNamePattern;
        }

        answer=new ArrayList<String>(resultSet);
        Collections.sort(answer);
        return answer;
    }
}
