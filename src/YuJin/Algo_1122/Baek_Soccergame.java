package YuJin.Algo_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Soccergame {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums[] = new int [n];
        for(int i=0; i<n; i++){ nums[i] = Integer.parseInt(st.nextToken());}
        Arrays.sort(nums);

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(sum <i*(i+1)/2){
                break;
            }
        }
        int check = (sum == n*(n-1)/2? 1:-1);
        System.out.print(check);
    }
}