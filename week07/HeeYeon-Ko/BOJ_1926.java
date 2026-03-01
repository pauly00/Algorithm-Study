import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0; // 그림의 개수
        int maxArea = 0;  // 가장 넓은 그림의 넓이

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0}; // 상우하좌
        int[] dy = {0, 1, 0, -1}; // 상우하좌


        // 도화지
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(board[i][j] == 0 || visited[i][j]){
                    continue;
                }

                queue.add(new Point(i, j));  // 시작점
                visited[i][j] = true;        // 시작점 방문
                int area = 0;                // 그림의 넓이

                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    area++;

                    for (int d = 0; d < 4; d++) {
                        int nx = point.x + dx[d];
                        int ny = point.y + dy[d];

                        // 범위 확인
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                            continue;
                        }
                        // 이미 방문했거나 0인 경우
                        if(board[nx][ny] == 0 || visited[nx][ny]) {
                            continue;
                        }

                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
                count++;

                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
