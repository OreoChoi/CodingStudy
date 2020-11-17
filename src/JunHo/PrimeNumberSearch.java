package JunHo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * jhChoi - 201117
 * 소수 찾기
 * */
public class PrimeNumberSearch {
    static int[] memoPrime;
    static Set<Integer> memoNum = new HashSet<>();
    static int result = 0;

    public int solution(String s) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }

        createPrimeNumber(getMaxNum(s));
        for (int i = 1; i <= arr.length; i++) {
            int[] output = new int[i];
            boolean[] visit = new boolean[arr.length];
            perm(arr, output, visit, 0, arr.length, i);
        }

        return result;
    }

    /**
     * 주어진 숫자를 큰 순위로 정렬 후 int 형으로 반환
     * */
    static int getMaxNum(String num){
        StringBuilder maxNum = new StringBuilder();
        char[] temp = num.toCharArray();
        Character[] arr = new Character[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (char c : arr) {
            maxNum.append(c);
        }

        return Integer.parseInt(maxNum.toString());
    }

    /**
     * 에라토스테네스의 체로 소수를 memoization하는 배열을 생성합니다.
     * */
    static void createPrimeNumber(int num) {
        memoPrime = new int[num + 1];

        for (int i = 2; i < memoPrime.length; i++) {  //2 ~ num까지 숫자를 초기화
            memoPrime[i] = i;
        }

        for (int i = 2; i <= num; i++) {    //2~num까지 소수 체크
            if (memoPrime[i] == 0) {        //소수가 아니라고 판명된 수는 pass
                continue;
            }
            for (int j = i + i; j <= num; j += i) { //(현재 수 * 2) ~ num 까지 순회하되 i만큼 증가
                memoPrime[j] = 0;
            }
        }
    }

    static void perm(int[] arr, int[] output, boolean[] visit, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder input = new StringBuilder();

            for (int put : output) {
                input.append(put);
            }

            int num = Integer.parseInt(input.toString());
            if (!memoNum.contains(num)) {
                memoNum.add(num);
                result = memoPrime[num] == 0 ? result : result+1;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visit, depth + 1, n, r);
                output[depth] = 0;
                visit[i] = false;
            }
        }
    }
}