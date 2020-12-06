class TheSongJustBefore {
    private String repAll(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
    public String solution(String m, String[] musicinfos) {
        String ans = "(None)";
        int maxlen = 0;

        m = repAll(m);
        for (String s : musicinfos) {
            String[] arr = s.split(",");

            int hour = Integer.parseInt(arr[1].split(":")[0]) - Integer.parseInt(arr[0].split(":")[0]);
            int min = Integer.parseInt(arr[1].split(":")[1]) - Integer.parseInt(arr[0].split(":")[1]);
            int sum = hour * 60 + min;
            String melody = repAll(arr[3]);
            String temp = "";
            for(int i = 0; i < sum; i++)
                temp += melody.charAt(i % melody.length());

            if(temp.contains(m) && maxlen < temp.length()) {
                maxlen = temp.length();
                ans = arr[2];
            }
        }
        return ans;
    }
}
