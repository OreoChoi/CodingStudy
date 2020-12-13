package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro_Draw {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 128;
        int a= 30;
        int b= 31;
        int answer = 1;

        int min = Math.min(a,b);
        int max = Math.max(a,b);

        while(true){
            if(min+1 == max && min %2 ==1 ) break;

            min = min/2 +min%2;
            max = max/2+max%2;
            answer++;
        }

        System.out.print(answer);
    }
}
