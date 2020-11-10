package JunHo;

import java.io.*;

/**
 * jhChoi - 20201102
 * 백준 - 설탕 배달
 * <p>
 * https://www.acmicpc.net/problem/2839
 */
public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        System.out.println(topDown(sugar, 0));
        //System.out.println(bottomUp(sugar));
    }

    /**
     * 메소드 동작 순서
     * 1. 현재 sugar는 5kg로 정확히 나눌 수 있니?
     * 2. (Yes인 경우) 5kg로 나누어 진 sugar 갯수를 리턴
     * 2. (No인 경우) 3kg 정도 설탕을 제거 하고 sugar 갯수를 1개 추가
     * 3. sugar가 3kg 정도씩 제거 하다가 -1 이하로 작아 지면 -1을 return
     * */
    public static int bottomUp(int sugar) {
        int count = 0;

        while (true) {
            if (sugar % 5 == 0) {       //5로 나뉘는 경우
                return sugar / 5 + count;
            } else if (sugar < 0) {   //정확하게 나뉘지 않는 경우
                return -1;
            }

            sugar = sugar - 3;          //5로 나뉘지 않는이상 3kg 설탕을 하나씩빼고 count를 1 증가
            count++;
        }
    }

    public static int topDown(int sugar, int count) {
        if(sugar == 0){
            return count;
        }

        if (sugar < 0) {
            return -1;
        } else if (sugar % 5 == 0) {
            return  count + sugar / 5;
        }

        return topDown(sugar - 3, ++count);
    }
}
