package week06.jeeneep;

import java.io.*;
import java.util.*;

// 9613
public class BOJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0; 
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }


    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}