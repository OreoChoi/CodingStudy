package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigNumProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int k = Integer.parseInt(br.readLine());

        System.out.println(solution(number,k));
    }
    public static String solution(String number, int k) {
        String answer = "";
        int [] nums = new int [number.length()];
        int i, max, start = -1, cnt =number.length()-k;

        for(i=0; i<number.length();i++){nums[i] =number.charAt(i) - '0';}

        while(cnt>0){
            max = nums[++start];
            for(i=start; i<nums.length-cnt+1; i++){
                if(nums[i]>max){
                    max =nums[i];
                    start= i;
                }
                if(max==9) break;
            }
            answer += max;
            cnt--;
        }
        return answer;
    }
}
