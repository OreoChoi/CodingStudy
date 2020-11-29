package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  인용된 횟수(K):            0 1 3 5 6
  K번 이상 인용된 논문의 갯수: 5 4 3 2 1
  -> 길이-인덱스
 */

public class Pro_HIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] citations = {3,0,6,1,5};
        Arrays.sort(citations);
        int answer =0;
        for(int i=0; i<citations.length; i++){
            if(  citations.length - i<=citations[i]){
                answer =citations.length-i;
                break;
            }

        }



    }
}

