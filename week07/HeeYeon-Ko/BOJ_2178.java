import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];          // 미로
        boolean[][] visited = new boolean[n][m];  // 방문 여부
        int[][] distance = new int[n][m];         // 거리 측정

        // 미로 초기화
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};  //상우하좌
        int[] dy = {0, 1, 0, -1};  //상우하좌

        // 시작점
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = point.x + dx[d];
                int ny = point.y + dy[d];

                // 범위 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                // 이미 방문했거나 0인 경우
                if(visited[nx][ny] || board[nx][ny] == 0){
                    continue;
                }

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                distance[nx][ny] = distance[point.x][point.y] + 1;
            }
        }

        System.out.println(distance[n-1][m-1]);
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
