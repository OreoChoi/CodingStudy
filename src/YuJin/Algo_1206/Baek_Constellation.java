package YuJin.Algo_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_Constellation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double [][]pos = new double[n+1][2];
        int [] parent = new int [n+1];
        List<Edge>edgeList =new ArrayList<>();

        for(int i=1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Double.parseDouble(st.nextToken());
            pos[i][1] =Double.parseDouble(st.nextToken());
            parent[i] = i;
        }

        for(int i=1; i<n+1; i++){
            for(int j=i+1; j<n+1; j++){
                double dis = Math.sqrt(Math.pow(pos[i][0]-pos[j][0],2)+Math.pow(pos[i][1]-pos[j][1],2));
                edgeList.add(new Edge(i,j,dis));
            }
        }

        Collections.sort(edgeList);

        double ans =0;

        for(int i=0; i<edgeList.size(); i++){
            Edge e = edgeList.get(i);
            if(!findParent(parent,e.start,e.end)){
                ans +=e.dis;
                unionParent(parent,e.start,e.end);
            }
        }
        System.out.print(ans);
    }

    public static class Edge implements Comparable<Edge>{
        int start,end;
        double dis;
        Edge(int start, int end, double dis){
           this.start =start;
           this.end =end;
           this.dis =dis;
        }

        @Override
        public int compareTo(Edge o) {
            if(dis<o.dis) return -1;
            else return  1;
        }
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

    public static boolean findParent(int[]parent, int a, int b){
        a=getParent(parent,a);
        b = getParent(parent, b);
        if(a==b) return true;
        else return false;
    }
}
