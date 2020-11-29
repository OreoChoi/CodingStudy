package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_SumIsZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] a = new int [n];
        int [] b = new int [n];
        int [] c = new int [n];
        int [] d = new int [n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int [] ab = new int [n*n];
        int [] cd = new int [n*n];
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[k] = a[i]+b[j];
                cd[k] =c[i]+d[j];
                k++;
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long cnt=0;
        int left=0, right = (n*n)-1;
        while(true){
            if( left>=(n*n)-1 || right<0) break;
            int lv = ab[left];
            int rv = cd[right];
            int sum = lv+rv;
            int abcnt =0;
            int cdcnt=0;
            if(sum < 0)while(++left<n*n-1 && ab[left] == lv){}
            else if(sum>0)while(--right>=0 && cd[right] ==rv){}
            else{
                abcnt++;
                cdcnt++;
                while(++left<n*n && ab[left] == lv){abcnt++;}
                while(--right>=0 && cd[right] ==rv){cdcnt++;}

                cnt += abcnt*cdcnt;
            }
        }

        System.out.print(cnt);

    }
}
