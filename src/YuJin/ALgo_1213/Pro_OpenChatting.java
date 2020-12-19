package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_OpenChatting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        ArrayList<String> entrylist = new ArrayList<>();
        ArrayList<String> idlist = new ArrayList<>();
        HashMap<String, String> nicknameMap = new HashMap<String, String>();
        ArrayList<String> answerlist = new ArrayList<>();
        StringTokenizer st;

        for(int i=0; i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String entry =st.nextToken();
            String id = st.nextToken();
            if(!entry.equals("Leave")) nicknameMap.put(id, st.nextToken());

            if(!entry.equals("Change")){
                entrylist.add(entry);
                idlist.add(id);
            }
        }

        for(String s: entrylist){
            String str =nicknameMap.get(idlist.get(0));
            idlist.remove(0);
            if(s.equals("Enter")) str +="님이 들어왔습니다.";
            else str +="님이 나갔습니다.";
            answerlist.add(str);
        }

        String [] answer = answerlist.toArray(new String[0]);

        for( String s: answer){
            System.out.println(s);
        }
    }
}

