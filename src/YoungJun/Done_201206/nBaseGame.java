package YoungJun.Done_201206;

class nBaseGame {
    String sy = "0123456789ABCDEF";

    private String base_to_s(int base, int n) {
        String s = "";
        while(n > 0) {
            s += sy.charAt(n % base);
            n /= base;
        }
        return (new StringBuffer(s)).reverse().toString();
    }

    public String solution(int n, int t, int m, int p) {
        String s = "0";
        String ans = "";

        for(int i = 0;; i++) {
            if(s.length() > m * t) break;
            s += base_to_s(n, i);
        }
        for(int i = 0; i < s.length() && ans.length() != t; i++)
            if(i % m == p - 1) ans += s.charAt(i);
        return ans;
    }
}
