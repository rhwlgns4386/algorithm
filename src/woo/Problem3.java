package woo;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            String s = String.valueOf(i);
            String[] split = s.split("");
            for(int j=0;j<split.length;j++){
                int parseInt = Integer.parseInt(split[j]);
                if(parseInt!=0&&parseInt%3==0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
