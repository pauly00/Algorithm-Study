package week07.jeeneep;

import java.io.*;
import java.util.*;

// 1260
public class BOJ_1260 {

    static StringBuilder sb;
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호 
        
        // 그래프 공간 만들기 (1번 정점부터, N번 정점까지 저장하기 위해 N+1개 )
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 M개 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향으로 넣어주기
            graph[u].add(v);
            graph[v].add(u);
        }

        // 방문할 수 있는 정점이 여러 개인 경우 -> 정점 번호가 작은 것 먼저 방문하도록 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        sb = new StringBuilder();

        // dfs에 사용할 visited 세팅
        visited = new boolean[N + 1];
        dfs(V);

        sb.append("\n");

        // bfs에 사용할 visited 세팅
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
;
    }

    static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            sb.append(cur).append(" ");

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
