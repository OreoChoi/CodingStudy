package YuJin.Algo_1122;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Pro_Morespicy {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] scoville = new int [st.countTokens()];
        for(int i=0; i<scoville.length; i++){
            scoville[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> scoqueue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){scoqueue.add(scoville[i]);}

        int cnt =0;
        while(true){
            boolean check =true;
            for( int i: scoqueue){
                if( i<K){
                    check =false;
                    cnt++;
                    break;
                }
            }
            if( check == false && scoqueue.size() == 1){
                cnt =-1;
                break;
            }
            if(check) break;

            scoqueue.add(scoqueue.poll()+scoqueue.poll()*2);
        }
        System.out.println(cnt);
    }
}

