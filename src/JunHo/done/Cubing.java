package JunHo.done;

import java.io.*;

/**
 * jhChoi - 201118
 * 큐빙
 * <p>
 * 왼쪽 면 회전시 - (위, 앞, 아래) 1열 & 뒷 3열 전체 변경
 * 시계 방향 시 - 앞 -> 아래 -> 뒤 -> 위 -> 앞
 * 반시계 방향 시 - 앞 -> 위 -> 뒤 -> 아래 -> 앞
 * <p>
 * 오른쪽 면 회전시 - (위, 앞, 아래) 3열 & 뒷 1열 전체 변경
 * 시계 방향 시 - 앞 -> 위 -> 뒤 -> 아래 -> 앞
 * 반시계 방향 시 - 앞 -> 아래 -> 뒤 -> 위 -> 앞
 * <p>
 * 윗면 회전시 - (앞, 왼쪽, 오른쪽, 뒤) 1행 전체 변경
 * 시계 방향 시 - 앞 -> 오른쪽 -> 뒤 -> 왼쪽 -> 앞
 * 반시계 방향 시 - 앞 -> 왼쪽 -> 뒤 -> 오른쪽 -> 앞
 * <p>
 * 아랫면 회전시 - (앞, 왼쪽, 오른쪽, 뒤) 3행 전체 변경
 * 시계 방향 시 - 앞 -> 오른쪽 -> 뒤 -> 왼쪽 -> 앞
 * 반시계 방향 시 - 앞 -> 왼쪽 -> 뒤 -> 오른쪽 -> 앞
 * <p>
 * 앞면 회전시 - (위, 왼쪽, 오른쪽, 아래) 3행, 3열, 1열, 3행 순으로 변경
 * 시계 방향 시 - 위 -> 오른쪽 -> 아래 -> 왼쪽 -> 위
 * 반시계 방향 시 - 위 -> 왼쪽 -> 아래 -> 오른쪽 -> 위
 * <p>
 * 뒷면 회전시 - (위, 왼쪽, 오른쪽, 아래) 1행, 1열, 3열, 1행 순으로 변경
 * 시계 방향 시 - 위 -> 왼쪽 -> 아래 -> 오른쪽 -> 위
 * 반시계 방향 시 - 위 -> 오른쪽 -> 아래 -> 왼쪽 -> 위
 */
public class Cubing {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcCount; i++) {
            int numOfRotation = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split(" ");
            new Cube(numOfRotation, command);
        }

        bw.flush();
    }

    static class Cube {
        char[][] U = {{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};   //위
        char[][] D = {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};   //아래
        char[][] F = {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};   //앞
        char[][] B = {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};   //뒤
        char[][] L = {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};   //왼쪽
        char[][] R = {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};   //오른쪽
        final int SIDE = 0;                                         //면
        final int DIRECTION = 1;                                    //회전 방향

        public Cube(int numOfRotation, String[] commands) {
            rotate(numOfRotation, commands);
        }

        /**
         * 한 면을 회전시킵니다.
         */
        private char[][] sideRotate(char[][] arr, boolean isPlus) {
            int n = arr.length;
            int m = arr[0].length;
            char[][] rotate = new char[m][n];

            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[i][j] = isPlus ? arr[n - 1 - j][i] : arr[j][n - 1 - i];
                }
            }
            return rotate;
        }

        /**
         * 커맨드에 맞춰 회전합니다.
         */
        private void rotate(int numOfRotation, String[] commands) {
            for (int i = 0; i < numOfRotation; i++) {
                char[] com = commands[i].toCharArray();
                char[] temp = new char[9];

                if (com[SIDE] == 'L') {
                    L = sideRotate(L,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(앞, 아래, 뒤, 위) 순
                        temp[0] = F[0][0];
                        temp[1] = F[1][0];
                        temp[2] = F[2][0];
                        F[0][0] = U[0][0];
                        F[1][0] = U[1][0];
                        F[2][0] = U[2][0];

                        temp[3] = D[0][0];
                        temp[4] = D[1][0];
                        temp[5] = D[2][0];
                        D[0][0] = temp[0];
                        D[1][0] = temp[1];
                        D[2][0] = temp[2];

                        temp[6] = B[2][2];
                        temp[7] = B[1][2];
                        temp[8] = B[0][2];
                        B[2][2] = temp[3];
                        B[1][2] = temp[4];
                        B[0][2] = temp[5];

                        U[0][0] = temp[6];
                        U[1][0] = temp[7];
                        U[2][0] = temp[8];
                    } else {  //(앞, 위, 뒤, 아래) 순
                        temp[0] = F[0][0];
                        temp[1] = F[1][0];
                        temp[2] = F[2][0];
                        F[0][0] = D[0][0];
                        F[1][0] = D[1][0];
                        F[2][0] = D[2][0];

                        temp[3] = U[0][0];
                        temp[4] = U[1][0];
                        temp[5] = U[2][0];
                        U[0][0] = temp[0];
                        U[1][0] = temp[1];
                        U[2][0] = temp[2];

                        temp[6] = B[2][2];
                        temp[7] = B[1][2];
                        temp[8] = B[0][2];
                        B[2][2] = temp[3];
                        B[1][2] = temp[4];
                        B[0][2] = temp[5];

                        D[0][0] = temp[6];
                        D[1][0] = temp[7];
                        D[2][0] = temp[8];
                    }
                } else if (com[SIDE] == 'R') {
                    R = sideRotate(R,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(앞, 위, 뒤, 아래) 순
                        temp[0] = F[0][2];
                        temp[1] = F[1][2];
                        temp[2] = F[2][2];
                        F[0][2] = D[0][2];
                        F[1][2] = D[1][2];
                        F[2][2] = D[2][2];

                        temp[3] = U[0][2];
                        temp[4] = U[1][2];
                        temp[5] = U[2][2];
                        U[0][2] = temp[0];
                        U[1][2] = temp[1];
                        U[2][2] = temp[2];

                        temp[6] = B[0][0];
                        temp[7] = B[1][0];
                        temp[8] = B[2][0];
                        B[2][0] = temp[3];
                        B[1][0] = temp[4];
                        B[0][0] = temp[5];

                        D[0][2] = temp[8];
                        D[1][2] = temp[7];
                        D[2][2] = temp[6];
                    } else {  //(앞, 아래, 뒤, 위) 순
                        temp[0] = F[0][2];
                        temp[1] = F[1][2];
                        temp[2] = F[2][2];
                        F[0][2] = U[0][2];
                        F[1][2] = U[1][2];
                        F[2][2] = U[2][2];

                        temp[3] = D[0][2];
                        temp[4] = D[1][2];
                        temp[5] = D[2][2];
                        D[0][2] = temp[0];
                        D[1][2] = temp[1];
                        D[2][2] = temp[2];

                        temp[6] = B[2][0];
                        temp[7] = B[1][0];
                        temp[8] = B[0][0];
                        B[2][0] = temp[3];
                        B[1][0] = temp[4];
                        B[0][0] = temp[5];

                        U[0][2] = temp[6];
                        U[1][2] = temp[7];
                        U[2][2] = temp[8];
                    }
                } else if (com[SIDE] == 'U') {
                    U = sideRotate(U,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(앞, 왼쪽, 뒤, 오른쪽) 순
                        temp[0] = F[0][0];
                        temp[1] = F[0][1];
                        temp[2] = F[0][2];
                        F[0][0] = R[0][0];
                        F[0][1] = R[0][1];
                        F[0][2] = R[0][2];

                        temp[3] = L[0][0];
                        temp[4] = L[0][1];
                        temp[5] = L[0][2];
                        L[0][0] = temp[0];
                        L[0][1] = temp[1];
                        L[0][2] = temp[2];

                        temp[6] = B[0][0];
                        temp[7] = B[0][1];
                        temp[8] = B[0][2];
                        B[0][0] = temp[3];
                        B[0][1] = temp[4];
                        B[0][2] = temp[5];

                        R[0][0] = temp[6];
                        R[0][1] = temp[7];
                        R[0][2] = temp[8];
                    } else {  //(앞, 오른쪽, 뒤, 왼쪽) 순
                        temp[0] = F[0][0];
                        temp[1] = F[0][1];
                        temp[2] = F[0][2];
                        F[0][0] = L[0][0];
                        F[0][1] = L[0][1];
                        F[0][2] = L[0][2];

                        temp[3] = R[0][0];
                        temp[4] = R[0][1];
                        temp[5] = R[0][2];
                        R[0][0] = temp[0];
                        R[0][1] = temp[1];
                        R[0][2] = temp[2];

                        temp[6] = B[0][0];
                        temp[7] = B[0][1];
                        temp[8] = B[0][2];
                        B[0][0] = temp[3];
                        B[0][1] = temp[4];
                        B[0][2] = temp[5];

                        L[0][0] = temp[6];
                        L[0][1] = temp[7];
                        L[0][2] = temp[8];
                    }
                } else if (com[SIDE] == 'D') {
                    D = sideRotate(D,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(앞, 오른쪽, 뒤, 왼쪽) 순
                        temp[0] = F[2][0];
                        temp[1] = F[2][1];
                        temp[2] = F[2][2];
                        F[2][0] = L[2][0];
                        F[2][1] = L[2][1];
                        F[2][2] = L[2][2];

                        temp[3] = R[2][0];
                        temp[4] = R[2][1];
                        temp[5] = R[2][2];
                        R[2][0] = temp[0];
                        R[2][1] = temp[1];
                        R[2][2] = temp[2];

                        temp[6] = B[2][0];
                        temp[7] = B[2][1];
                        temp[8] = B[2][2];
                        B[2][0] = temp[3];
                        B[2][1] = temp[4];
                        B[2][2] = temp[5];

                        L[2][0] = temp[6];
                        L[2][1] = temp[7];
                        L[2][2] = temp[8];
                    } else {  //(앞, 왼쪽, 뒤, 오른쪽) 순
                        temp[0] = F[2][0];
                        temp[1] = F[2][1];
                        temp[2] = F[2][2];
                        F[2][0] = R[2][0];
                        F[2][1] = R[2][1];
                        F[2][2] = R[2][2];

                        temp[3] = L[2][0];
                        temp[4] = L[2][1];
                        temp[5] = L[2][2];
                        L[2][0] = temp[0];
                        L[2][1] = temp[1];
                        L[2][2] = temp[2];

                        temp[6] = B[2][0];
                        temp[7] = B[2][1];
                        temp[8] = B[2][2];
                        B[2][0] = temp[3];
                        B[2][1] = temp[4];
                        B[2][2] = temp[5];

                        R[2][0] = temp[6];
                        R[2][1] = temp[7];
                        R[2][2] = temp[8];
                    }
                } else if (com[SIDE] == 'F') {
                    F = sideRotate(F,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(위, 오른쪽, 아래, 왼쪽) 순
                        temp[0] = U[2][0];
                        temp[1] = U[2][1];
                        temp[2] = U[2][2];
                        U[2][2] = L[0][2];
                        U[2][1] = L[1][2];
                        U[2][0] = L[2][2];

                        temp[3] = R[0][0];
                        temp[4] = R[1][0];
                        temp[5] = R[2][0];
                        R[0][0] = temp[0];
                        R[1][0] = temp[1];
                        R[2][0] = temp[2];

                        temp[6] = D[0][0];
                        temp[7] = D[0][1];
                        temp[8] = D[0][2];
                        D[0][2] = temp[3];
                        D[0][1] = temp[4];
                        D[0][0] = temp[5];

                        L[0][2] = temp[6];
                        L[1][2] = temp[7];
                        L[2][2] = temp[8];
                    } else {  //(위, 왼쪽, 아래, 오른쪽) 순
                        temp[0] = U[2][0];
                        temp[1] = U[2][1];
                        temp[2] = U[2][2];
                        U[2][0] = R[0][0];
                        U[2][1] = R[1][0];
                        U[2][2] = R[2][0];

                        temp[3] = L[0][2];
                        temp[4] = L[1][2];
                        temp[5] = L[2][2];
                        L[2][2] = temp[0];
                        L[1][2] = temp[1];
                        L[0][2] = temp[2];

                        temp[6] = D[0][0];
                        temp[7] = D[0][1];
                        temp[8] = D[0][2];
                        D[0][0] = temp[3];
                        D[0][1] = temp[4];
                        D[0][2] = temp[5];

                        R[2][0] = temp[6];
                        R[1][0] = temp[7];
                        R[0][0] = temp[8];
                    }
                } else {
                    B = sideRotate(B,com[DIRECTION] == '+');
                    if (com[DIRECTION] == '+') {  //(위, 왼쪽, 아래, 오른쪽) 순
                        temp[0] = U[0][0];
                        temp[1] = U[0][1];
                        temp[2] = U[0][2];
                        U[0][0] = R[0][2];
                        U[0][1] = R[1][2];
                        U[0][2] = R[2][2];

                        temp[3] = L[0][0];
                        temp[4] = L[1][0];
                        temp[5] = L[2][0];
                        L[2][0] = temp[0];
                        L[1][0] = temp[1];
                        L[0][0] = temp[2];

                        temp[6] = D[2][0];
                        temp[7] = D[2][1];
                        temp[8] = D[2][2];
                        D[2][0] = temp[3];
                        D[2][1] = temp[4];
                        D[2][2] = temp[5];

                        R[2][2] = temp[6];
                        R[1][2] = temp[7];
                        R[0][2] = temp[8];
                    } else {  //(위, 오른쪽, 아래, 왼쪽) 순
                        temp[0] = U[0][0];
                        temp[1] = U[0][1];
                        temp[2] = U[0][2];
                        U[0][2] = L[0][0];
                        U[0][1] = L[1][0];
                        U[0][0] = L[2][0];

                        temp[3] = R[0][2];
                        temp[4] = R[1][2];
                        temp[5] = R[2][2];
                        R[0][2] = temp[0];
                        R[1][2] = temp[1];
                        R[2][2] = temp[2];

                        temp[6] = D[2][0];
                        temp[7] = D[2][1];
                        temp[8] = D[2][2];
                        D[2][2] = temp[3];
                        D[2][1] = temp[4];
                        D[2][0] = temp[5];

                        L[0][0] = temp[6];
                        L[1][0] = temp[7];
                        L[2][0] = temp[8];
                    }
                }
            }
            buildPrintU();
        }

        /**
         * 윗면을 출력합니다.
         */
        void buildPrintU() {
            try {
                for (char[] tile : U) {
                    for (char c : tile) {
                        bw.write(c);
                    }
                    bw.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
