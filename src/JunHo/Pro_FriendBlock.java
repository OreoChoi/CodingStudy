package JunHo;

/**
 * jhChoi - 201207
 * 프로그래머스 - 프렌즈 4블록
 */
public class Pro_FriendBlock {
    public static void main(String[] args) {
        String[] board = {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"};
        String[] board2 = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };
        //System.out.println(solution(6, 6, board));
        System.out.println(solution(4, 5, board2));
    }

    static char[][] board;                    //게임용 보드
    static int boardWidth;                    //게임용 보드 너비
    static int boardHeight;                   //게임용 보드 높이
    static int[] right = {1, 1, 0};           //우측,우측 하단, 하단
    static int[] bottom = {0, 1, 1};          //우측,우측 하단, 하단
    static int answer = 0;                    //터진 블록 갯수
    static int roundPopCount = 0;             //이번 라운드 터진 횟수

    public static int solution(int m, int n, String[] input) {
        createBoard(input, m, n);

        do {
            for (int line = 0; line < boardHeight - 1; line++) {
                for (int curIndex = 0; curIndex < boardWidth - 1; curIndex++) {
                    if (board[line][curIndex] != 0) checkPopBlock(line, curIndex);
                }
            }

            if (roundPopCount > 0) {
                rePositionMap();
                roundPopCount = 0;
            } else {
                break;
            }
        } while (true);

        return answer;
    }

    //터진 블록을 제거하고 맵을 재배치 합니다.
    static void rePositionMap() {
        char[][] repositionMap = new char[boardHeight][boardWidth];
        for (int wI = 0; wI < boardWidth; wI++) {  //너비 만큼 회전
            int inputIndex = boardHeight - 1;     //input할 인덱스

            for (int lI = boardHeight - 1; lI >= 0; lI--) { //라인마다 체크
                if (board[lI][wI] >= 97 && board[lI][wI] <= 122) {   //소문자로 변환된(터질 블록)들은 터진블록으로 포함합니다.
                    answer++;
                } else if (board[lI][wI] >= 65 && board[lI][wI] <= 90) {  //대문자인 블록은 새로운 보드에 입력합니다.
                    repositionMap[inputIndex][wI] = board[lI][wI];
                    inputIndex--;
                }
            }
        }

        board = repositionMap;  //기존 board 폐기, 새로운 board 삽입
    }

    //String Array 형태의 board를 Char Array 형태로 변경합니다.
    static void createBoard(String[] input, int m, int n) {
        board = new char[m][n];

        for (int i = 0; i < input.length; i++) {
            board[i] = input[i].toCharArray();
        }

        boardWidth = n;
        boardHeight = m;
    }

    //대문자 -> 소문자
    static char upperCase(char c) {
        if (c >= 65 && c <= 90) return (char) (c + 32);
        else return c;
    }

    //현재 블록의 우측, 우측하단, 하단을 확인후 3개 모두 일치시 블록을 !로 변경합니다.
    static void checkPopBlock(int line, int curIndex) {
        char currentTile = upperCase(board[line][curIndex]);    //소문자로 변경 후 확인
        int popCount = 0;
        for (int i = 0; i < 3; i++) {
            int l = line + bottom[i];
            int idx = curIndex + right[i];
            if (idx < boardWidth && l < boardHeight) {    //접근할 수 있는 인덱스인지 확인
                if (upperCase(board[l][idx]) == currentTile) popCount++;
            }
        }


        if (popCount == 3) {
            roundPopCount++;
            currentTile = board[line][curIndex] = upperCase(currentTile);   //대문자 -> 소문자

            for (int i = 0; i < 3; i++) {
                int l = line + bottom[i];
                int idx = curIndex + right[i];
                board[l][idx] = currentTile;
            }
        }
    }
}
