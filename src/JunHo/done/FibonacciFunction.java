package JunHo;

import java.io.*;

/**
 * jhChoi - 20201104
 *  피보나치 수열을 구현한 프로그램
 * */
public class FibonacciFunction {
    static Fibonacci[] memo = new Fibonacci[41];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        memo[0] = new Fibonacci();  //0과 1은 미리 초기화
        memo[1] = new Fibonacci();
        memo[0].zeroCount = 1;
        memo[1].oneCount = 1;

        for (int i = 0; i < N; i++) {
            int q = Integer.parseInt(br.readLine());

            for (int j = 2; j <= q; j++) {
                if(memo[j] == null){    //memoization이 되지 않은 숫자면 실행
                    Fibonacci nFibo = new Fibonacci();
                    nFibo.zeroCount = memo[j-1].zeroCount + memo[j-2].zeroCount;
                    nFibo.oneCount = memo[j-1].oneCount + memo[j-2].oneCount;
                    memo[j] = nFibo;
                }
            }

            bw.write(memo[q].zeroCount + " " + memo[q].oneCount + "\n");
        }

        bw.flush();
    }

    static class Fibonacci {
        int zeroCount = 0;
        int oneCount = 0;
    }
}


