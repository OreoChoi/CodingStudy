package JunHo.done;

import java.util.Arrays;
import java.util.Scanner;

/**
 * jhChoi - 201126
 * 백준 - 로봇 프로젝트
 *
 * [런타임 에러 시]
 *  문제를 잘 읽어보면 "입력은 여러 개의 테스트 케이스로 이루어져 있다."
 *  라고 적혀있다.
 *  예제가 1개 적혀있다고 해서 입력은 한번만 이뤄지는것이 아니다.
 *  아랫 코드 12번 라인을 참고하면 될 것 같다.
 *
 * [시간 초과 시]
 *   Set으로 풀려고 하신분이 계신다고해서... 알고리즘 분류가 이분탐색이니 이분탐색으로 하는 것을 추천드립니다.
 */
public class Beak_RobotProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            long x = sc.nextInt() * 10000000;
            int n = sc.nextInt();
            int[] legoArr = new int[n];

            for (int i = 0; i < n; i++) {
                legoArr[i] = sc.nextInt();
            }

            Arrays.sort(legoArr);   //이진탐색을 위한 정렬

            int left = 0, right = legoArr.length - 1;

            while (left < right) {
                long sum = legoArr[left] + legoArr[right];

                if (sum == x) { //찾는 숫자인 경우
                    break;
                }

                if (sum < x) { //찾는 숫자보다 이전에 있는 경우
                    left++;
                } else {       //찾는 숫자보다 이후에 있는 경우
                    right--;
                }
            }

            if(left >= right){
                System.out.println("danger");
            }else{
                System.out.println(String.format("yes %d %d",legoArr[left],legoArr[right]));;
            }
        }
    }
}
