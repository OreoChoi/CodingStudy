package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
각 행은 i의 배수.
각 행마다 B[k]/i 를 하면 몇번째 열인지 알 수 있음.
j(n)보다 커지게 되면 out.
 */
public class Baek_KNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int answer =0;
        int start =1, end=k;
        while(start<=end){
            int mid = (start+end)/2;
            int cnt =0;
            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            } // 갯수 구하기
            if(cnt >=k){
                answer = mid;
                end =mid-1;
            }else start =mid+1;
        }

        System.out.print(answer);


    }
}
