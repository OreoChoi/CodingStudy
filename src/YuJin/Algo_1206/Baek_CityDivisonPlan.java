package YuJin.Algo_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_CityDivisonPlan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edgeList =new ArrayList<Edge>();
        int [] parent =new int [n+1];
        for(int i=1; i<n+1; i++){ parent[i] =i;}

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a,b,cost));
        }

        Collections.sort(edgeList); //비용 순으로 오름차순 정리.

        //N-1개의 길로 연결되도록해서 최댓값을 나중에 빼주기
        int ans =0;
        int max =0;
        for(int i=0; i<edgeList.size(); i++){
            Edge e = edgeList.get(i);

            if(!findParent(parent,e.a,e.b)){
                ans +=e.cost;
                unionParent(parent,e.a,e.b);
                max =e.cost;
            }
        }
        System.out.print(ans-max);
    }

    public static class Edge implements Comparable<Edge>{
        int a, b, cost;
        Edge(int a, int b, int cost){
            this.a = a;
            this.b =b;
            this.cost =cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost,o.cost);
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
