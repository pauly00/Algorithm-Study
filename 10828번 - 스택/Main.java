/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10828                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: pauly <boj.kr/u/pauly>                      +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10828                          #+#        #+#      #+#    */
/*   Solved: 2026/01/06 15:07:59 by pauly         ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] stack = new int[n];
        int top =0;

        for(int i=0; i<n; i++) {
            String line = br.readLine(); // 명령어(배열 필요없음)
            String[] split = line.split(" "); // 문자열 분리(push)
            
            String command = split[0];

            switch(command) { // 명령어만 분리 필요
                // push: 정수 x를 스택에 넣는다
                case "push":
                    int value = Integer.parseInt(split[1]);
                    stack[top++] = value; // 직접 추가
                    break;
                // pop: 스택에서 가장 위의 정수빼고 출력
                case "pop":
                    if (top==0) bw.write(-1+"\n");
                    else bw.write(stack[--top]+"\n");
                    break;
                // size: 스택에 들어있는 정수 개수 출력
                case "size": bw.write(top+"\n");
                    break;
                // empty: 스택가 비어있으면 1, 아니면 0
                case "empty":
                    if (top==0) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                // top: 스택의 가장 위 정수 출력    
                case "top":
                    if (top==0) bw.write(-1+"\n");
                    else bw.write(stack[top-1]+"\n");
                    break;
            }
            // bw.write('\n');
        }
        bw.flush();
    }
}