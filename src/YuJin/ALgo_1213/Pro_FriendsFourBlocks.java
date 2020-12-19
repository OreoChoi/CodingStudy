package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pro_FriendsFourBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 6;
        int n= 6;

        String [][] boards = new String[m][n];

        for(int i=0; i<m; i++){
           String [] str = board[i].split("");
            for(int j=0; j<n; j++){ boards[i][j] = str[j]; }
        }

        int cnt=0;
        boolean flag =true;
        while(flag){
            flag =false;
            boolean[][] visited = new boolean[m][n];
            Stack[] stacks = new Stack[n];
            for(int i=0; i<n; i++){stacks[i] = new Stack<String>();}

            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    String target = boards[i][j];
                    if(target.equals("0")) continue;
                    if( target.equals(boards[i][j+1]) &&target.equals(boards[i+1][j]) &&target.equals(boards[i+1][j+1])){
                        visited[i][j] =true;
                        visited[i][j+1] =true;
                        visited[i+1][j] =true;
                        visited[i+1][j+1] =true;
                    }
                }
            }// 없어지는 블록 찾기

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                  if(visited[i][j]){
                      flag =true;
                      cnt++;
                  }else{ stacks[j].add(boards[i][j]);}
                }
            }   //갯수 세주기

            for(int i=0; i<n; i++){
                for(int j=m-1; j>=0; j--){
                    if(stacks[i].isEmpty()) boards[j][i] = "0";
                    else boards[j][i] =(String)stacks[i].pop();
                }
            }
        }

        System.out.print(cnt);
    }
}

