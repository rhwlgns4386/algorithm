package algospot;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CANDY {
    public static void main(String[] args) {

        int[] candies = new int[20];
        int N = candies.length;

        for(int i=0;i<N;i++){
            candies[i]= (int)(Math.random()*20)+1;
        }

        System.out.println(Arrays.toString(candies));

        Runnable task1 = () -> System.out.println("브루트포스 : "+CANDY_BRUT_FORCE.solution(N,candies));
        Runnable task2 = () -> System.out.println("너비우선 탐색 : "+ CANDY_BFS.solution(N,candies));
        Runnable task3 = () -> System.out.println("너비우선 탐색 범위 제한 : "+CANDY_BFS_RANGE_LIMIT.solution(N,candies));
        Runnable task4 = () -> System.out.println("너비우선 탐색 오름차순 설정 : "+CANDY_BFS_SORTING.solution(N,candies));

        Thread thread1=new Thread(task1);
        Thread thread2=new Thread(task2);
        Thread thread3=new Thread(task3);
        Thread thread4=new Thread(task4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    static class CANDY_BRUT_FORCE {

        private static int solution(int n, int[] candies) {
            int[] users = new int[3];
            return go(n, candies, users, 0);
        }

        private static int go(int n, int[] candies, int[] users, int index) {
            if (n == index) {
                return Arrays.stream(users).max().getAsInt() - Arrays.stream(users).min().getAsInt();
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                users[i] += candies[index];
                result = Math.min(result, go(n, candies, users, index + 1));
                users[i] -= candies[index];
            }

            return result;
        }
    }

    static class CANDY_BFS {

        static class Node {
            int first;
            int second;
            int third;

            int index;

            public Node(int first, int second, int third,int index) {
                this.first = first;
                this.second = second;
                this.third = third;
                this.index =index;
            }
        }

        private static int solution(int n, int[] candies) {
            int arrayLen = 20 * n + 1;
            return bfs(n, candies, arrayLen);
        }

        private static int bfs(int n, int[] candies, int arrayLen) {
            boolean[][][] visit = new boolean[arrayLen][arrayLen][arrayLen];
            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 0,0));
            visit[0][0][0] = true;

            while (q.peek().index!=n) {
                Node node = q.remove();
                int index=node.index;

                int[] users = {node.first, node.second, node.third};
                for (int i = 0; i < 3; i++) {
                    users[i] += candies[index];
                    if (!visit[users[0]][users[1]][users[2]]) {
                        q.add(new Node(users[0], users[1], users[2],index+1));
                        visit[users[0]][users[1]][users[2]] = true;
                    }
                    users[i] -= candies[index];
                }
            }

            int result = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                Node node = q.remove();
                int[] users = {node.first, node.second, node.third};
                int value = Arrays.stream(users).max().getAsInt() - Arrays.stream(users).min().getAsInt();
                result = Math.min(value, result);
            }

            return result;
        }
    }

    static class CANDY_BFS_RANGE_LIMIT {

        static class Node {
            int first;
            int second;
            int third;

            int index;
            public Node(int first, int second, int third,int index) {
                this.first = first;
                this.second = second;
                this.third = third;
                this.index =index;
            }
        }

        private static int solution(int n, int[] candies) {
            int arrayLen =((20 * n) / 3) + 20;
            return bfs(n, candies, arrayLen);
        }

        private static int bfs(int n, int[] candies, int arrayLen) {
            boolean[][][] visit = new boolean[arrayLen][arrayLen][arrayLen];
            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 0,0));
            visit[0][0][0] = true;

            while (q.peek().index!=n) {
               Node node = q.remove();
                int index=node.index;

                int[] users = {node.first, node.second, node.third};
                for (int i = 0; i < 3; i++) {
                    users[i] += candies[index];
                    if (users[i] < arrayLen && !visit[users[0]][users[1]][users[2]]) {
                        q.add(new Node(users[0], users[1], users[2],index+1));
                        visit[users[0]][users[1]][users[2]] = true;
                    }
                    users[i] -= candies[index];
                }
            }

            int result = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
               Node node = q.remove();
                int[] users = {node.first, node.second, node.third};
                int value = Arrays.stream(users).max().getAsInt() - Arrays.stream(users).min().getAsInt();
                result = Math.min(value, result);
            }

            return result;
        }

    }

    static class CANDY_BFS_SORTING {

        static class Node {
            int first;
            int second;
            int third;

            int index;

            public Node(int first, int second, int third, int index) {
                this.first = first;
                this.second = second;
                this.third = third;
                this.index = index;
            }
        }

        private static int solution(int n, int[] candies) {
            int arrayLen = ((20 * n) / 3) + 20;
            return bfs(n, candies, arrayLen);
        }

        private static int bfs(int n, int[] candies, int arrayLen) {
            boolean[][][] visit = new boolean[arrayLen][arrayLen][arrayLen];
            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 0, 0));
            visit[0][0][0] = true;

            while (q.peek().index != n) {
                Node node = q.remove();
                int index = node.index;


                for (int i = 0; i < 3; i++) {
                    Integer[] users = {node.first, node.second, node.third};
                    users[i] += candies[index];
                    if(users[i]<arrayLen){
                        Arrays.sort(users, Collections.reverseOrder());
                        if (!visit[users[0]][users[1]][users[2]]) {
                            q.add(new Node(users[0], users[1], users[2], index + 1));
                            visit[users[0]][users[1]][users[2]] = true;
                        }
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                Node node = q.remove();
                int[] users = {node.first, node.second, node.third};
                int value = Arrays.stream(users).max().getAsInt() - Arrays.stream(users).min().getAsInt();
                result = Math.min(value, result);
            }

            return result;
        }
    }
}
