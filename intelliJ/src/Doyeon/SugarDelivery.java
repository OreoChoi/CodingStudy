package Doyeon;

import java.util.*;

/**
 * 다이나믹 프로그래밍 이용해서 처리
 */
public class SugarDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        // 1부터 ~ N까지
        for (int i = 1; i < d.length; i++) {
            // 1부터 5까지는 예외처리
            if (i <= 2) {
                d[i] = -1;
            } else if (i == 3 || i == 5) {
                d[i] = 1;
            } else if (i == 4) {
                d[i] = -1;
            } else {
                if (d[i-3] == -1 && d[i-5] == -1) { // 이전값이 둘다 불가한 경우였으면, 현재 값도 불가
                    d[i] = -1;
                } else if (d[i-3] == -1) { // 이전값 i-3이 불가한 경우 i-5의 경우에 +1
                    d[i] = d[i-5] + 1;
                } else if (d[i-5] == -1) { // 이전값 i-5이 불가한 경우 i-3의 경우에 +1
                    d[i] = d[i-3] + 1;
                } else { // 둘 다 가능한 경우 작은 값을 찾은 뒤 + 1
                    d[i] = Math.min(d[i-3], d[i-5]) + 1;
                }
            }
        }
        System.out.println(d[n]);
    }
}