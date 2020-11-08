package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] zero = new int [41];
        int [] one = new int [41];
        zero[0] = 1;
        zero[1] = 0;
        one[0] =0;
        one[1] =1;

        int i;
        for(i=2; i<41; i++ ){
            zero[i] = zero[i-1]+zero[i-2];
            one[i] =one[i-1]+one[i-2];
        }

        int T = Integer.parseInt(br.readLine());
        for(i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(zero[N]+" "+one[N]+'\n');
        }
        System.out.println(sb);
    }
}
