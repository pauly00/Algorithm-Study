/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18258                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: pauly <boj.kr/u/pauly>                      +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18258                          #+#        #+#      #+#    */
/*   Solved: 2026/01/06 15:07:44 by pauly         ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
// import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 테스트케이스 통과용
        // System.out.printf("1\n2\n2\n0\n1\n2\n-1\n0\n1\n-1\n0\n3");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        // String[] command = new String[n]; // 명령어 배열

        int[] queue = new int[n];
        int front = 0;
        int rear = 0;
        
        for(int i=0; i<n; i++) {
            String line = br.readLine(); // 명령어(배열 필요없음)
            String[] split = line.split(" "); // 문자열 분리(push)
            
            String command = split[0];

            switch(command) { // 명령어만 분리 필요
                // push: 정수 x를 큐에 넣는다
                case "push":
                    int value = Integer.parseInt(split[1]);
                    // queue.push(split[1]); // 존재하지 않음
                    queue[rear++] = value; // 직접 추가
                    break;
                // pop: 큐에서 가장 앞의 정수빼고 출력
                case "pop":
                    if (front == rear) // System.out.println(-1);
                        bw.write(-1+"\n");
                    else // System.out.println(queue[front++]);
                        bw.write(queue[front++]+"\n");
                    break;
                // size: 큐에 들어있는 정수 개수 출력
                case "size": // System.out.println(rear-front); // +1하면 안됨
                        bw.write(rear-front+"\n");
                    break;
                // empty: 큐가 비어있으면 1, 아니면 0
                case "empty":
                    // if queue.empty push 1
                    if (front == rear) // System.out.println(1);
                        bw.write(1+"\n");
                    // else push 0
                    else //System.out.println(0);
                        bw.write(0+"\n");
                    break;

                // front: 큐의 가장 앞에 있는 정수 출력(없으면 -1)
                case "front":
                    // null 체크 null / '\0' / isEmpty() 모두 불가
                    if (front == rear) //System.out.println(-1);
                        bw.write(-1+"\n");
                    else //System.out.println(queue[front]);
                        bw.write(queue[front]+"\n");
                    break;
                // back: 큐의 가장 뒤에 있는 정수 출력(없으면 -1)
                case "back":
                    if (front == rear) //System.out.println(-1);
                        bw.write(-1+"\n");
                    else //System.out.println(queue[rear-1]); // rear는 다음에 들어갈 위치
                        bw.write(queue[rear-1]+"\n");
                    break;
            }
            // bw.write('\n');
        }
        bw.flush();
    }
}