package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_PhoneBook {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer =true;

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()) return 1;
                else if(o1.length()<o2.length()) return -1;
                else return 0;
            }
        });

        for(int i=0; i<phone_book.length-1; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if( phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
                if(!answer) break;
            }
        }

    }
}

