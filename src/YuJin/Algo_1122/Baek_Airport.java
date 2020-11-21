package YuJin.Algo_1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_Airport {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int [] airplanes = new int [P+1];
        int [] parent = new int [G+1];
        int cnt =0,i;

        for(i=1; i<=G; i++){ parent[i]=i;}

        for(i=1; i<=P; i++) {
            airplanes[i] = Integer.parseInt(br.readLine());
        }

        for(i=1; i<=P; i++){
            int checkgate = getParent(parent,airplanes[i]);

            if(checkgate==0) break;
            cnt++;
            unionParent(parent,checkgate,checkgate-1);
        }
        System.out.print(cnt);
    }
    public static int getParent(int[] parent,int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent,parent[x]);
    }

    public static void unionParent(int []parent, int a, int b){
        a= getParent(parent, a);
        b =getParent(parent,b);
        if(a<b) parent[b]=a;
        else parent[a] =b;
    }
}
