package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pro_Camouflage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            else hashMap.put(clothes[i][1], 2);
        }

        for (String type : hashMap.keySet()) {
            answer *= hashMap.get(type);
        }
        answer--;
    }
}

