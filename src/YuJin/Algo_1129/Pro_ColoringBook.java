package YuJin.Algo_1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro_ColoringBook {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m =6;
        int n =4;
        int [][]picture = { {1,1,1,0},
                            {1,2,2,0},
                            {1,0,0,1},
                            {0,0,0,1},
                            {0,0,0,3},
                            {0,0,0,3}};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int [][] p =picture;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( p[i][j] == 0) continue;
                else{
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(findarea(p[i][j], p, i, j, m, n),maxSizeOfOneArea);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(answer[0]+","+answer[1]);
    }

    public static int findarea(int color, int[][] picture, int i, int j, int m, int n){
       if(i>=m || j>=n || i<0 || j<0 || color != picture[i][j] ) return 0;

        int cnt =1;
        picture[i][j] = 0;

        cnt += findarea(color,picture, i-1, j,m,n);
        cnt += findarea(color,picture, i+1, j,m,n);
        cnt += findarea(color,picture, i, j-1, m, n);
        cnt += findarea(color, picture, i, j+1, m,n);

        return cnt;
    }
}

