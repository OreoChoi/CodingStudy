package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_ShortestDistance {
    static class Node implements  Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight){
            this.end =end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight -o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer( );
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int spos = Integer.parseInt(br.readLine());

        int [] distance = new int[v+1];
        boolean [] visited =new boolean[v+1];
        ArrayList<Node> [] adjlist = new ArrayList[v+1];
        for(int i=0; i<=v; i++){
            adjlist[i] = new ArrayList<Node>();
        }

        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjlist[start].add(new Node(end,weight));
        }

        PriorityQueue <Node> pq = new PriorityQueue<>();
        distance[spos] = 0;
        pq.add(new Node(spos,0));
        while(!pq.isEmpty()){
            Node cnode = pq.poll();
            if(visited[cnode.end]) continue;
            visited[cnode.end] = true;

            for(Node n: adjlist[cnode.end]){
                if(distance[n.end]>distance[cnode.end]+n.weight){
                    distance[n.end]= distance[cnode.end]+n.weight;
                    pq.offer(new Node(n.end,distance[n.end]));
                }
            }
        }
        for(int i=1; i<=v; i++){
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(distance[i]+"\n");
        }
        System.out.print(sb);

    }
}

