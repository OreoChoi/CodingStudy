package JunHo;

import java.io.*;

/**
 * jhChoi - 201125
 * 백준 - K번째 수 (문제 풀이 실패)
 *
 * 이해 불가 ㅠㅠ
 */
public class Baek_Knumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1, right = K;
        long ans = 0;

        // 이분 탐색 수행
        while (left <= right) {
            long mid = (left + right) / 2; // 임의의 수 지정
            long cnt = 0;

            // mid보다 작거나 같은 수는 몇 개인지 계산.
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
