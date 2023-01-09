import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] resultList = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        //init
        stack.push(0);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        while (stringTokenizer.hasMoreTokens()){
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        //getResult
        for(int i=1;i<n;i++){
            if(stack.empty()){
                stack.push(i);
            }
            while (!stack.empty() && list.get(stack.peek())<list.get(i)){
                resultList[stack.pop()]=list.get(i);
            }
            stack.push(i);
        }

        while (!stack.empty()){
            resultList[stack.pop()]=-1;
        }

        Arrays.stream(resultList).forEach(i->{
            try {
                bufferedWriter.write(i+" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
