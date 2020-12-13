package YuJin.Algo_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_Downhill {
    static int M;
    static  int N;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [M][N];
        dp = new int[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }}

        System.out.print( dfs(0,0));
    }

    public static int dfs ( int i, int j){
        if(i==M-1 && j== N-1) return 1;       //맨끝 도달 하면 1
        if(dp[i][j]==-1) dp[i][j] =0;   //방문한적 없을 경우, 표시로 0

        if(i>0 && arr[i][j] >arr[i-1][j]) dp[i][j] += dfs(i-1, j);
        if(i<M-1 && arr[i][j] >arr[i+1][j]) dp[i][j] += dfs(i+1, j);
        if(j>0 && arr[i][j] > arr[i][j-1]) dp[i][j] += dfs(i,j-1);
        if(j<N-1 && arr[i][j] > arr[i][j+1]) dp[i][j] +=dfs(i,j+1);

        return dp[i][j];
    }


}
