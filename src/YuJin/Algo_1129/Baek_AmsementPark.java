package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
각 놀이기구가 t분까지 태우는 사람 수 : t/A, t/B,,,
각 t분에 타는 사람수 : t%A ==0 인경우
 */

public class Baek_AmsementPark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] times = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= m) {
            System.out.print(n);
            return;
        }

        long left = 0;
        long right = n - 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            int start = 0, end = n;
            //각 시간별로 타는 사람들.
            for (int i = 0; i < m; i++) {
                end += mid / times[i];
            }
            start = end;
            //각 기구당 mid 시간에 찬 사람들은 뺴줌.
            for (int i = 0; i < m; i++) {
                if (mid % times[i] == 0) start--;
            }
            start++;

            if (n < start) right = mid - 1;
            else if (n > end) left = mid + 1;
            else {
                for (int i = 0; i < m; i++) {
                    if (mid % times[i] == 0) {
                        if (n == start) {
                            System.out.print(i + 1);
                            return;
                        }
                        start++;
                    }
                }
            }
        }


        return;
    }
}
