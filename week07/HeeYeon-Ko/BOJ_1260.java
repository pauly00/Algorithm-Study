import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260 {

    static int N;
    static int M;
    static int V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 정점의 번호

        // 인접 행렬
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // DFS
        dfs(V);
        sb.append("\n");

        // 방문 기록 초기화
        visited = new boolean[N+1];

        // BFS
        bfs(V);

        System.out.println(sb);

    }

    // DFS
    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i < N+1; i++) {
            if(graph[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    // BFS
    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V]=true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append(" ");
            for (int j = 1; j < N+1; j++) {
                if(graph[num][j] == 1 && !visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
