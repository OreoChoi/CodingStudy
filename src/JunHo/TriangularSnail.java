package JunHo;

/**
 * jhChoi - 20201103
 * 프로그래머스 삼각 달팽이
 *
 * 알고리즘 예시)
 * 문제 : 5층 달팽이를 만드시오
 *
 * 1. factorial(5) = 15개
 * 2. arr[15] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; 생성
 * 3. 우측 순회 입력
 *    arr[15] {1,2,0,3,0,0,4,0,0,0,5,6,7,8,9}
 * 4. 좌측 순회 입력
 *    arr[15] {1,2,12,3,0,11,4,0,0,10,5,6,7,8,9}
 * 5. 우측 순회 입력
 *    arr[15] {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
 *
 * <p>
 * Factorial Memoization 전
 * 테스트 1 〉	통과 (0.03ms, 52.6MB)
 * 테스트 2 〉	통과 (0.02ms, 52.4MB)
 * 테스트 3 〉	통과 (0.01ms, 52.6MB)
 * 테스트 4 〉	통과 (2.61ms, 53.9MB)
 * 테스트 5 〉	통과 (2.24ms, 53.9MB)
 * 테스트 6 〉	통과 (3.16ms, 53.3MB)
 * 테스트 7 〉	통과 (866.08ms, 114MB)
 * 테스트 8 〉	통과 (380.19ms, 112MB)
 * 테스트 9 〉	통과 (378.18ms, 110MB)
 * <p>
 * Factorial Memoization 후
 * 테스트 1 〉	통과 (0.02ms, 52.9MB)
 * 테스트 2 〉	통과 (0.02ms, 53.6MB)
 * 테스트 3 〉	통과 (0.02ms, 52.4MB)
 * 테스트 4 〉	통과 (0.81ms, 53.7MB)
 * 테스트 5 〉	통과 (0.79ms, 53.8MB)
 * 테스트 6 〉	통과 (0.86ms, 53.1MB)
 * 테스트 7 〉	통과 (15.01ms, 110MB)
 * 테스트 8 〉	통과 (16.80ms, 112MB)
 * 테스트 9 〉	통과 (16.30ms, 111MB)
 * <p>
 * Factorial 계산식 변경 (재귀 -> 간편 식)
 * 테스트 1 〉	통과 (0.02ms, 52.3MB)
 * 테스트 2 〉	통과 (0.02ms, 53.2MB)
 * 테스트 3 〉	통과 (0.02ms, 52.4MB)
 * 테스트 4 〉	통과 (0.33ms, 52.9MB)
 * 테스트 5 〉	통과 (0.38ms, 54MB)
 * 테스트 6 〉	통과 (0.35ms, 52.9MB)
 * 테스트 7 〉	통과 (14.34ms, 110MB)
 * 테스트 8 〉	통과 (15.00ms, 111MB)
 * 테스트 9 〉	통과 (13.95ms, 110MB)
 */
public class TriangularSnail {
    public static void main(String[] args) {
        int[] result = solution(6);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }


    static int[] solution(int n) {
        int lastHead = n;    //오른쪽 순회 시 마지막으로 들러야하는 행
        int[] factorial = createFactorial(n);
        int[] answer = new int[factorial[n]];

        int rightCount = 0;   //배열을 오른쪽으로 순회한 횟수
        int leftCount = 1;    //배열을 좌측으로 순회한 횟수
        int count = 1;        //answer 배열에 순서대로 입력될 숫자
        int initCount = 0;

        while (count <= factorial[n]) {

            while (count <= factorial[n]) {      //down Input
                int i = factorial[initCount] + rightCount;
                answer[i] = count++;

                if (lastHead == answer[i - rightCount]) {
                    for (int j = i; j < i + answer[i - rightCount]; j++) {
                        if (count > factorial[n]) {
                            break;
                        } else if (answer[j] == 0) {
                            answer[j] = count++;
                        }
                    }
                    lastHead--;
                    break;
                }

                ++initCount;
            }

            ++rightCount;
            while (count <= factorial[n]) {    //up Input
                int i = factorial[initCount] - leftCount;
                answer[i] = count++;

                int nextI = factorial[--initCount] - leftCount;
                if (nextI < 0 || answer[nextI] > 0) {
                    leftCount++;
                    break;
                }
            }

            ++initCount;
        }

        return answer;
    }

    /**
     * 팩토리얼 배열 생성
     * 팩토리얼 식 : i * (i+1) /2;
     * 예제 1)      5 * (5+1) /2;
     * = 15
     */
    static int[] createFactorial(int n) {
        int[] factorial = new int[n + 1];

        factorial[0] = 0;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * (i + 1) / 2;
        }

        return factorial;
    }
}



