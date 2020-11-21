package YuJin.Algo_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Scale {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] weights = new int [N];
        for(int i=0; i<N; i++){ weights[i] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(weights);

        int sum =1;

        for(int i=0; i<N; i++){
            if(weights[i]>sum) break;
            else sum+=weights[i];
        }

        System.out.println(sum);
    }
}

