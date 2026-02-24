package week07.jeeneep;

import java.io.*;
import java.util.*;

// 2606
public class BOJ_2606 {

    static ArrayList<Integer>[] graph;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 정점의 수 (vertex)
        int M = Integer.parseInt(br.readLine()); // 간선의 수 (edge)

        // 그래프 공간 만들기
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 간선 정보 M개 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // dfs를 위한 visited 세팅
        visited = new boolean[N + 1];
        dfs(1);

        // 컴퓨터 1 자신은 count에 포함하지 않음
        count--;
        System.out.println(count);

    }

    static void dfs(int cur) {
        visited[cur] = true;
        count++;

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
}
