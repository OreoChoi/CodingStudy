package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baek_RobotProject {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(br.readLine())*10000000;
        int n = Integer.parseInt(br.readLine());
        int [] rego = new int [n];
        for(int i=0; i<n; i++){
            rego[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rego);
        int left =0;
        int right = rego.length-1;
        String result ="danger";

        while(left<right){
            long sum = rego[left]+rego[right];
            if(x==sum) {
                result ="yes "+rego[left]+" "+rego[right];
                break;
            }else if(sum<x){
                left++;
            }else right--;
        }

        System.out.print(result);

    }
}

