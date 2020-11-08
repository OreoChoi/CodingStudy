package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriSnailProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = solution(n);
        for( int i: arr) { System.out.print(i+", "); }
    }

    public static int[] solution(int n) {
        int [][]arr = new int [n][n];
        int [] answer = new int [n*(n+1)/2];
        int row=0,col=0,checkpoint =1, num=1, rotation=n, i,j;

        while(rotation>=1){
            if(checkpoint ==1){
                for(i=1; i<=rotation; i++){ arr[row++][col] =num++;}
                checkpoint =2;
                col ++;
                row --;
            }else if(checkpoint ==2){
                for(i=1; i<=rotation; i++){ arr[row][col++] =num++;}
                checkpoint =3;
                row--;
                col-=2;
            }else{
                for(i=1; i<=rotation; i++){ arr[row--][col--] = num++;}
                checkpoint =1;
                row+=2;
                col++;
            }
            rotation--;
        }
        num =0;
        for(i=0; i< arr.length; i++){for( j=0; j<=i; j++){answer[num++] =arr[i][j];}}

        return answer;
    }
}
