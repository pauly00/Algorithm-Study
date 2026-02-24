import java.io.*;
import java.util.*;


public class Main {
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int countComputer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int pairComputer= Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=computer; i++) {
            graph.add(new ArrayList<>());
        }


        for(int i=0; i<pairComputer; i++) {
            String[] tmp = br.readLine().split(" ");
            int a=Integer.parseInt(tmp[0]);
            int b=Integer.parseInt(tmp[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        isVisited = new boolean[computer+1];
        bfs(1);

        System.out.println(countComputer-1); // 1번 제외
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        isVisited[start] = true;

        while(!q.isEmpty()) {
            int current = q.remove();
            countComputer++;

            for(int next: graph.get(current)) {
                if(!isVisited[next]){
                    q.add(next);
                    isVisited[next] =true;
                }
            }

        }
    }
}