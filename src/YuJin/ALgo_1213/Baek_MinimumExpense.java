package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 1915번
 */

public class Baek_MinimumExpense {
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node( int end, int weight){
            this.end= end;
            this.weight =weight;
        }

        @Override
        public int compareTo(Node o) {
            if(weight>o.weight) return 1;
            else if(weight == o.weight) return 0;
            else return -1;
        }
    }
    static ArrayList<ArrayList<Node>> adjlist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N =Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adjlist = new ArrayList<>();
        for(int i=0; i<=N ; i++){ adjlist.add(new ArrayList<Node>()); }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjlist.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        System.out.print(dijkstra(N,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
    }

    public static int dijkstra(int n, int spos, int epos){
        int [] distance = new int [n+1];
        boolean [] visited = new boolean [n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(spos,0));
        distance[spos] =0;

        while(! queue.isEmpty()){
            Node curnode = queue.poll();
            int current = curnode.end;

            if(visited[current]) continue;
            visited[current] = true;

            for(Node nextnode : adjlist.get(current)){
                if( distance[nextnode.end] >distance[current]+nextnode.weight){
                    distance[nextnode.end] =distance[current]+nextnode.weight;
                    queue.offer(new Node(nextnode.end,distance[nextnode.end]));
                }
            }
        }
        return distance[epos];
    }
}

