package JunHo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * jhChoi - 201201
 * 프로그래머스 - 압축
 */
public class Compression {
    public static void main(String[] args) {
        //int[] result = solution("KAKAO");
        //int[] result2 = solution("TOBEORNOTTOBEORTOBEORNOT");
        //int[] result3 = solution("ABABABABABABABAB");
        int[] result4 = solution("THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS");

    }

    static int maxWordCount = 1;    //사전에 들어있는 문자의 최대 길이
    static String msg;

    public static int[] solution(String message) {
        msg = message;
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> dic = createDictionary();
        HashMap<String, Integer> newDic = new HashMap<>();

        while (msg.length() > 0) {
            int searchWordCount = Math.min(maxWordCount, msg.length());
            String searchWord = "";

            while (searchWordCount > 0) {
                if (searchWordCount == 1) {
                    searchWord = cutString(searchWordCount);
                    result.add(dic.get(searchWord));
                    break;
                } else {
                    int index = newDic.getOrDefault(msg.substring(0, searchWordCount), 0);
                    if (index > 0) {
                        searchWord = cutString(searchWordCount);
                        result.add(index);
                        break;
                    } else {
                        searchWordCount--;
                    }
                }
            }

            if (msg.length() >0) {
                StringBuilder newWord = new StringBuilder();
                newWord.append(searchWord).append(msg, 0, 1);
                newDic.put(newWord.toString(), newDic.size() + 27);
                maxWordCount = Math.max(maxWordCount,newWord.length());
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static String cutString(int end) {
        String cutString = msg.substring(0, end);
        msg = msg.substring(end);
        return cutString;
    }

    //A~Z를 담은 HashMap을 생성합니다.
    public static HashMap<String, Integer> createDictionary() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            dictionary.put(Character.toString('A' + (i - 1)), i);
        }
        return dictionary;
    }
}
