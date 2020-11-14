package YuJin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Kruskal_1115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int v= Integer.parseInt(st.nextToken());
        int e =Integer.parseInt(st.nextToken());

        ArrayList<Edge> list = new ArrayList<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(v1,v2,cost));
        }
        Collections.sort(list);
        int [] parent = new int [v+1];
        for(int i=1; i<=v; i++){
            parent[i] =i;
        }

        int sum=0;
        for(int i=0; i<list.size();i++){
            Edge edge = list.get(i);
            if(UnionFind.findParent(parent,edge.v1,edge.v2) == 0){
                sum +=edge.cost;
                UnionFind.unionParent(parent,edge.v1,edge.v2);
            }
        }

        System.out.println(sum);
    }
}

