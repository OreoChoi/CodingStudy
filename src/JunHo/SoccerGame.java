package JunHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * jhChoi - 201119
 * 축구게임
 */
public class SoccerGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        int conSum = N * (N - 1) / 2;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum < i * (i + 1) / 2) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sum == conSum ? 1 : -1);
    }

}
