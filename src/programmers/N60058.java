package programmers;

import java.util.Stack;

public class N60058 {
    public static void main(String[] args) {

        testing("(()())()","(()())()");
        testing(")(","()");
        testing("()))((()","()(())()");
        testing("()()","()()");
        testing(")()(","(())");
    }

    public static void testing(String input,String result){
        N60058 main = new N60058();
        String output = main.solution(input);
        if(!output.equals(result)){
            System.out.println(output);
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
    }

    public String solution(String p) {
        return makingProperBracket(p);
    }

    private String makingProperBracket(String p) {
        if(p.length()==0) return p;

        int subIndex=findSubIndex(p)+1;
        String u=p.substring(0,subIndex);
        String v=p.substring(subIndex);
        if(isProperBracket(u)){
            return u+makingProperBracket(v);
        }

        StringBuilder result=new StringBuilder("("+makingProperBracket(v));
        result.append(")");
        for(int i=1;i<u.length()-1;i++){
            if(u.charAt(i)=='('){
                result.append(')');
            }else{
                result.append('(');
            }
        }

        return result.toString();
    }

    private boolean isProperBracket(String u) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='('){
                stack.add(1);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private int findSubIndex(String s) {
        int sum=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sum+=1;
            }else{
                sum-=1;
            }

            if(sum==0){
                return i;
            }
        }

        return s.length();
    }
}
