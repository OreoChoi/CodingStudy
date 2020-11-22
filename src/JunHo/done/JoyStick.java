package JunHo.done;

import java.util.HashMap;

public class JoyStick {
    private static boolean[] visit; //방문 여부
    private static int visitCount = 0; //방문 숫자

    static int solution(String n) {
        int answer = 0;
        StringBuilder name = new StringBuilder(n);
        visit = new boolean[name.length()];
        HashMap<Character, Integer> alphaMap = getAlphaMap();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') checkVisit(i);
        }

        int pos = 0;
        answer += alphaMap.get(n.charAt(pos));
        checkVisit(pos);

        while (visitCount < name.length()) {
            Distance dis = getDistance(name, pos);

            if (dis.lDistance >= dis.rDistance) {       //좌측으로 가는 길이와 똑같거나 작거나
                pos = dis.rIndex;
                answer += dis.rDistance;
            } else {  //우측보다 좌측이 확실히 작은 경우
                pos = dis.lIndex;
                answer += dis.lDistance;
            }

            checkVisit(pos);
            answer += alphaMap.get(n.charAt(pos));
        }

        return answer;
    }

    /**
     * 현재 위치를 처음 방문하면 방문에 체크합니다.
     *
     * @param pos 방문할 위치
     */
    static void checkVisit(int pos) {
        if (!visit[pos]) {
            visit[pos] = true;
            visitCount++;
        }
    }

    /**
     * 현재 위치에서 변경되지 않은 알파벳을 찾습니다.
     *
     * @param name 문자열
     * @param pos  현재 위치
     */
    static Distance getDistance(StringBuilder name, int pos) {
        Distance dis = new Distance();
        int leftPos = pos;

        do {
            leftPos = (leftPos == 0) ? (name.length() - 1) : (leftPos - 1);
            dis.lDistance++;
        } while (visit[leftPos]);
        dis.lIndex = leftPos;

        do {
            pos = pos == (name.length() - 1) ? 0 : (pos + 1);
            dis.rDistance++;
        } while (visit[pos]);
        dis.rIndex = pos;

        return dis;
    }

    /**
     * 현재 위치에서
     * 좌측에 있는 방문하지 않은 알파벳과
     * 우측에 있는 방문하지 않은 알파벳에 대한 정보를 갖습니다.
     */
    static class Distance {
        int lIndex;
        int lDistance = 0;
        int rIndex;
        int rDistance = 0;
    }

    /**
     * 정방향 순
     * A B C D E F G H I J K  L  M  N
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13
     * 역방향 순서
     * Z  Y  X  W  V  U  T  S  R  Q  P  O  N
     * 1  2  3  4  5  6  7  8  9  10 11 12 13
     */
    static HashMap<Character, Integer> getAlphaMap() {
        HashMap<Character, Integer> alphaMap = new HashMap<>();
        char alphabet = 'A';
        int position = 0;

        for (int i = 0; i <= 25; i++) {
            alphaMap.put(alphabet, position);
            position = (i < 13) ? ++position : --position;
            alphabet++;
        }

        return alphaMap;
    }
}
