package JunHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * jhChoi - 201126
 * 합이 0인 네 정수
 * <p>
 * SumIsZero
 */
public class SumIsZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] A = new int[size];
        int[] B = new int[size];
        int[] C = new int[size];
        int[] D = new int[size];
        int[] AB = new int[size * size];
        HashMap<Integer, Integer> CD = new HashMap<>();

        //데이터 입력
        for (int i = 0; i < size; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(input.nextToken());
            B[i] = Integer.parseInt(input.nextToken());
            C[i] = Integer.parseInt(input.nextToken());
            D[i] = Integer.parseInt(input.nextToken());
        }

        /**
         * 1. A배열과 B배열 병합 -> AB배열 생성
         * 2. C배열과 D배열 병합 -> HashMap(C+B, C+B라는 key의 중복된 값)
         * */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                AB[i * size + j] = A[i] + B[j];

                int cdInput = C[i] + D[j];
                CD.put(cdInput, CD.getOrDefault(cdInput, 1) + 1);
            }
        }

        long count = 0;
        for (int i : AB) {
            if (CD.containsKey(-i)) count += CD.get(-i);
        }

        System.out.print(count);
    }
}
