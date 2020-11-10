package Doyeon;

import java.util.Scanner;

/**
 * 미리 0 ~ 40개를 할당해놓고 처리
 * 메모이제이션 이용
 */
public class FibonacciFunction {
    public static int[][] fibonacci = new int[41][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fibonacci[0][0] = 1;
        fibonacci[1][1] = 1;
        fibonacci[2][0] = 1;
        fibonacci[2][1] = 1;
        // 미리 40까지 다 계산해놓은 뒤
        for (int i = 3; i < fibonacci.length; i++) {
            fibonacci[i][0] = fibonacci[i-2][0] + fibonacci[i-1][0];
            fibonacci[i][1] = fibonacci[i-2][1] + fibonacci[i-1][1];
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.print(fibonacci[n][0]);
            System.out.print(" ");
            System.out.print(fibonacci[n][1]);
            System.out.println();
        }
    }
}
