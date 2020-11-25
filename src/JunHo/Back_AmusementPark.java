package JunHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * jhChoi - 201125
 * 백준 놀이공원
 *
 * [공식]
 * long x분 탑승 어린이 수 =  M + x/rateTime[0] + x/rateTime[1] ... x/rateTime[last]
 * boolean x분 탑승 가능 놀이 기구 = x % rateTime[i] == 0
 *
 */
public class Back_AmusementPark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);  //아이들 수
        int M = Integer.parseInt(input[1]); //1인승 놀이기구 수
        int[] rateTime = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            rateTime[i] = Integer.parseInt(input[i]);
        }

        if (N <= M) { //아이들 수 보다 놀이기구 수가 많은 경우
            System.out.println(N);
            return;
        }

        long lMin = 0;                      //이분탐색 시작 Min
        long rMin = 2000000000L * 10000L;   //이분탐색 종료 Min

        while (lMin <= rMin) {
            long midMin = (lMin + rMin) / 2;
            long crtN = M;                  //midMin에 탑승 중인 어린이 수

            for (int i = 0; i < M; i++) {   //midMin에 탑승한 어린이 수 산출
                crtN += midMin / rateTime[i];
                if (crtN > N) break;
            }

            if (crtN > N) {                 //탑승 수가 N(태울 수)보다 많은 경우
                rMin = midMin - 1;
            } else if (crtN == N) {         //탑승 수와 N(태울 수)와 동일한 경우
                rMin = rMin - 1;
            } else {                        //탑승 수가 N(태울 수)보다 적은 경우
                long nextMin = midMin + 1;  //해당 분에 N명이 전원 탑승했는지 체크
                long count = crtN;
                for (int i = 0; i < M; i++) {
                    if (nextMin % rateTime[i] == 0) count++;
                    if (count == N) {
                        System.out.println(i + 1);
                        return;
                    }
                }

                lMin = midMin + 1;
            }
        }
    }
}
