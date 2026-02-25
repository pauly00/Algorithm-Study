
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11724                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11724                          #+#        #+#      #+#    */
/*   Solved: 2026/02/25 15:07:37 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수 
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수 

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 1];

        int result = 0;

        // 연결 요소 찾기
        // - 시작 노드를 1로 고정하면 안됨. 
        // - dfs 후에 그래프에서 방문하지 않은 노드를 찾아서 그 노드부터 다시 dfs
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(graph, i, visited);
                result++;
            }
        }

        System.out.println(result);

    }

    public static void dfs(List<List<Integer>> graph, int cur, boolean[] visited){
        visited[cur] = true;

        for(int next : graph.get(cur)){
            if(!visited[next]){
                dfs(graph, next, visited);
            }
        }
    }
}