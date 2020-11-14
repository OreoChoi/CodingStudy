package YuJin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeforeYou_1115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int a= Integer.parseInt(st.nextToken());
        int b =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()); //문자의 개수
        int m=Integer.parseInt(st.nextToken()); //문자쌍의 개수

        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            adjList[t1].add(t2);
            adjList[t2].add(t1);
        }

        Queue<Integer> queue =new LinkedList<Integer>();
        queue.add(a);
        int [] dist = new int [n+1];
        for(int i =2; i<= dist.length;i++){
            dist[i] = n;  //최대 비용값
        }
        while(queue.size() !=0){
            int v = queue.poll();
            for( int i = 0; i<adjList[v].size();i++){
                int next = adjList[v].get(i);
                if(dist[next]>dist[v]+1) {
                    dist[next] = dist[v]+1;
                    queue.add(next);
                }
            }
        }
        if( dist[b] == n) System.out.println(-1);
        else System.out.print(dist[b]);
    }
}

