package YuJin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fcnt = N/5;
        int tcnt = (N%5)/3;
        int rem = (N%5)%3;

        if(rem == 1){
            tcnt +=2;
            fcnt --;
        }else if(rem ==2){
            tcnt +=4;
            fcnt -=2;
        }
        if(fcnt <0 ) System.out.println(-1);
        else System.out.println(fcnt+tcnt);
    }
}
