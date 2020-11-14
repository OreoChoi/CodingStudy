package YuJin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarNumber_1115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt = 0;
        if(s =="cd" || s=="dc"){
            cnt = 10*26;
        }else if(s=="dd"){
            cnt = 10*9;
        }else cnt = 26*25;

        System.out.println(cnt);
    }
}
