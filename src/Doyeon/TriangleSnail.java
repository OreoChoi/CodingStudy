package Doyeon;

import java.util.Arrays;

/**
 * 규칙을 찾아서 처리
 */
public class TriangleSnail {
    public static int[] solution(int n) {
        // 삼각배열
        int[][] triArr = new int[n][];
        // 초기화
        for (int i = 0; i < triArr.length; i++) {
            triArr[i] = new int[i+1];
        }
        // 시작값
        int num = 1;
        int x = -1;
        int y = 0;
        while (n > 0) {
            for (int i = 0; i < n; i++) { // 아래쪽
                // x를 n번 ++
                triArr[++x][y] = num++;
            }
            // 한 부분이 끝나면 n을 --해야함
            n--;
            for (int i = 0; i < n; i++) { // 오른쪽
                // y를 n번 ++
                triArr[x][++y] = num++;
            }
            n--;
            for (int i = 0; i < n; i++) { // 위쪽
                // x와 y를 n번 --
                triArr[--x][--y] = num++;
            }
            n--;
        }
        int index = 0;
        int[] result = new int[num-1];
        for (int i = 0; i < triArr.length; i++) {
            for (int j = 0; j < triArr[i].length; j++) {
                result[index] = triArr[i][j];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }
}
