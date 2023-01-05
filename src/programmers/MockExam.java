package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    static int [][]  memberNum={{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public static void main(String[] args) {
        int[] tem={1,3,2,4,2};
        System.out.println(Arrays.toString(solution(tem)));
    }
    public static int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] countList=new int[3];
        for(int j=0;j<memberNum.length;j++){
            for(int i=0;i<answers.length;i++){
                if(memberNum[j][i%memberNum[j].length]==answers[i]) countList[j]+=1;
            }
        }
        int[] copyOf = Arrays.copyOf(countList, countList.length);
        Arrays.sort(copyOf);
        for(int i=0;i<3;i++){
            if(countList[i]==copyOf[2]){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}
