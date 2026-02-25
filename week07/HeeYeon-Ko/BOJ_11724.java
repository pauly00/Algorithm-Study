import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int answer = 0;

        // 인접 리스트
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src].add(dst);
            graph[dst].add(src);
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int node){
        visited[node] = true;

        for(int nextNode : graph[node]){
            if(!visited[nextNode]){
                dfs(nextNode);
            }
        }
    }
}
