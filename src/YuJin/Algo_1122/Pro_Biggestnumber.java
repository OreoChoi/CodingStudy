package YuJin.Algo_1122;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_Biggestnumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int [] numbers = {3, 30, 34, 5, 9};
        String [] str = new String[numbers.length];
        int sum=0;  //원소가 모두 0인 경우를 체크해주기 위해서
        String answer ="";

        for(int i=0; i< numbers.length;i++){
            sum+=numbers[i];
            str[i] = Integer.toString(numbers[i]);
        }

        if( sum !=0){
            Arrays.sort(str, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return -(o1+o2).compareTo(o2+o1);    // 더 큰 수를 앞에 둬야하기 떄문에 -붙이기.
                }
            });

            for(String s: str){
                answer +=s;
            }
        }else answer = "0";

        System.out.println(answer);
    }
}

