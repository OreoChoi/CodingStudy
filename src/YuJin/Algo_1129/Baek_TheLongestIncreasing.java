package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    문제가 잘 이해가지 않아 미완성.
 */
public class Baek_TheLongestIncreasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        List<Integer> list = new ArrayList<>();
        int before = 0;
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] =Integer.parseInt( st.nextToken());
            if (arr[i] > before) list.add(arr[i]);
            before = arr[i];
        }
        System.out.print(list.size());
    }
}
