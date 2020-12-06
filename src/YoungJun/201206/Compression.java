import java.util.*;

class Compression {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 1;
        char c = 'A';

        for(int i = 0; i < 26; i++)
            dic.put(c++ + "", idx++);

        String word = "";
        for(int i = 0; i < msg.length(); i++) {
            word += msg.charAt(i);
            if(!dic.containsKey(word)) {
                arr.add(dic.get(word.substring(0, word.length() - 1)));
                dic.put(word, idx++);
                word = "";
                i--;
            }
        }
        arr.add(dic.get(word));

        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            answer[i] = arr.get(i);

        return answer;
    }
}
