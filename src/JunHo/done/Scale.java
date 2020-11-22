package JunHo.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * jhChoi - 201118
 * 저울
 *
 * 예
 * 7
 * 1 1 2 3 6 7 30
 *
 * 찾을 숫자 : 21
 * 21보단 작은 근접 숫자 : 7
 * 7부터 -> 1까지 덧셈시작
 * 7 + 6 + 3 + 2 + 1 + 1 = 20
 * 21안나옵니다. ㅜㅜ 최소 숫자~!
 */
public class Scale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        int max = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Integer.parseInt(input[i]);
            max += weight[i];
        }

        Arrays.sort(weight);

        int minWeight = 1;
        while (max >= minWeight) {
            int index = binarySearch(weight, minWeight);

            if (weight[index] != minWeight) { //일치하는 숫자가 없는 경우 해당 숫자가 조합이 되는지 탐색
                int sum = 0;
                for (int i = index; i >= 0; i--) {
                    if (minWeight >= sum + weight[i]) {
                        sum += weight[i];
                    }

                    if (sum == minWeight) {
                        break;
                    }
                }

                if (sum != minWeight) {
                    break;
                }
            }

            minWeight++;
        }
        System.out.println(minWeight);
    }

    /**
     * 찾는 숫자가 있으면 해당 index를 반환하며
     * 찾는 숫자가 없으면 근접한 index를 반환합니다.
     */
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return mid;
    }
}
