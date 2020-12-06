package YoungJun.Done_201206;

import java.util.*;

class sortFileName {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] l1 = get(s1);
                String[] l2 = get(s2);
                int p = l1[0].compareTo(l2[0]);

                if(p == 0)
                    return Integer.parseInt(l1[1]) - Integer.parseInt(l2[1]);
                return p;
            }

            private String[] get(String str) {
                String a = "";
                String b = "";

                for(char c : str.toCharArray()) {
                    if(!b.isEmpty() && !(c >= '0' && c <= '9')) break;
                    if(c >= '0' && c <= '9') b += c;
                    else a += c;
                }
                String[] l = {a.toLowerCase(), b};
                return l;
            }
        });
        return files;
	}
}
