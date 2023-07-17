package beakjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final String SEPARATOR = " ";

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        n = Integer.parseInt(br.readLine());
        int nn = n * n;

        List<Integer> order = new ArrayList<>();

        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < nn+1; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < nn; i++) {
            stz = new StringTokenizer(br.readLine(), SEPARATOR);

            int a = Integer.parseInt(stz.nextToken());
            order.add(a);

            for (int j = 0; j < 4; j++) {
                int b = Integer.parseInt(stz.nextToken());
                relations.get(a).add(b);
            }
        }

        int[][] classroom = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                classroom[i][j] = -1;
            }
        }

        Map<Integer, int[]> seat = new HashMap<>();
        for (int i = 0; i < nn; i++) {
            int person = order.get(i);


            // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            int maxNearFriendCount = 0;
            List<int[]> firstCondition = new ArrayList<>();
            int[][] nearFriends = new int[n][n];
            for (int j = 0; j < 4; j++) {
                int likeFriend = relations.get(person).get(j);

                if (seat.containsKey(likeFriend)) { // 좋아하는 친구가 이미 좌석 배정이 끝났을 때.
                    int cx = seat.get(likeFriend)[0];
                    int cy = seat.get(likeFriend)[1];

                    for (int d = 0; d < 4; d++) { // 인접 네 방향 확인
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (!inRange(nx, ny)) continue;
                        if (classroom[nx][ny] != -1) continue; // 비어있는지 확인

                        nearFriends[nx][ny] += 1;
                        maxNearFriendCount = Math.max(maxNearFriendCount, nearFriends[nx][ny]);
                    }
                }
            }

            // 친구 근처의 비어있는 자리가 없거나, 이미 배정된 친구가 없을 수 있음
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (nearFriends[x][y] == maxNearFriendCount && classroom[x][y] == -1) {
                        firstCondition.add(new int[]{x, y});
                    }
                }
            }


            List<int[]> secondCondition = new ArrayList<>();
            if (firstCondition.size() == 1) {
                // 1의 유일한 경우일 때
                int x = firstCondition.get(0)[0];
                int y = firstCondition.get(0)[1];

                classroom[x][y] = person;
                seat.put(person, new int[]{x, y});
                continue;
            } else {
                secondCondition.addAll(firstCondition);
            }

            // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            int[][] blanks = new int[n][n];
            int maxBlanks = 0;
            List<int[]> thirdCondition = new ArrayList<>();
            for (int[] condition : secondCondition) {
                int cx = condition[0];
                int cy = condition[1];

                // 인접한 칸 중에서 비어있는 칸의 개수를 셈
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (!inRange(nx, ny)) continue;
                    if (classroom[nx][ny] != -1) continue;

                    cnt += 1;
                }

                blanks[cx][cy] = cnt;
                maxBlanks = Math.max(maxBlanks, cnt);
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (blanks[x][y] == maxBlanks && classroom[x][y] == -1) thirdCondition.add(new int[]{x, y});
                }
            }

            // 3. 2를 만족하는 칸도 여러 개인 경우에 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            thirdCondition.sort((o1, o2) -> {
                    return o1[0] - o2[0];
                });

            int x = thirdCondition.get(0)[0];

            thirdCondition=thirdCondition.stream().filter(o->o[0]==x).collect(Collectors.toList());
            int y;
            if(thirdCondition.size()==1){
                y=thirdCondition.get(0)[1];
            }else{
                thirdCondition.sort((o1, o2) -> {
                    return o1[1] - o2[1];
                });
                y=thirdCondition.get(0)[1];
            }

            classroom[x][y] = person;
            seat.put(person, new int[]{x, y});
        }

        int answer = calculationSatisfaction(classroom, relations);

        System.out.println(answer);
        br.close();
    }

    private static boolean inRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n);
    }

    private static int calculationSatisfaction(int[][] classroom, List<List<Integer>> list) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int like = 0;
                int person = classroom[i][j];

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (!inRange(nx, ny)) continue;

                    int near = classroom[nx][ny];
                    if (list.get(person).contains(near)) like++;
                }

                int satisfaction = (like == 0) ? 0 : (int) Math.pow(10, like - 1);
                sum += satisfaction;
            }
        }

        return sum;
    }
}