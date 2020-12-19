package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_Alpha {
    static int row, col, max=0;
    static char [][]arr;
    static boolean[]visited =new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr =new char [row][col];

        for(int i=0; i<row; i++){
            String s = br.readLine();
            for(int j=0; j<col; j++){ arr[i][j] = s.charAt(j); }
        }

        dfs(0,0,1);
        System.out.print(max);
    }

    public static void dfs( int i, int j, int depth) {
        if(i<0 || i>=row || j<0 || j>col) return;
        if(arr[i][j] =='@') return;
        if(visited[arr[i][j]-'A']) return;

        char c= arr[i][j];
        visited[arr[i][j]-'A'] =true;
        arr[i][j] = '@';

        max =Math.max(max,depth);
        dfs(i-1,j,depth+1);
        dfs(i+1, j, depth+1);
        dfs(i,j-1,depth+1);
        dfs(i,j+1,depth+1);

        arr[i][j] = c;
    }
}

