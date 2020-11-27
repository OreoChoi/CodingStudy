package JunHo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * jhChoi - 201126
 * 가장 긴 증가하는 부분 수열2
 */
public class Baek_LongNumberTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] answer = new int[N+1];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(input[i]);
            answer[i] = -1;
        }

        answer[0] = 0;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (answer[idx] < sequence[i]) {  //다음 숫자가 훨씬 큰 경우
                answer[++idx] = sequence[i];
            } else if (answer[idx] > sequence[i]) {    //이진탐색
                lowBound(answer, sequence[i],idx);
            }
        }

        System.out.println(idx);
    }

    public static void lowBound(int arr[], int target,int size) {
        int l = 0;
        int r = size;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;

            if (arr[mid] == target) {
                return;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int arrLastIndex = arr.length -1;
        if (arr[mid] > target) {
            arr[mid] = target;
        } else if (arrLastIndex >= mid && arr[mid + 1] > target) {
            arr[mid + 1] = target;
        }
    }
}

