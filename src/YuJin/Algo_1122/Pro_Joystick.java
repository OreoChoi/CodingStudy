package YuJin.Algo_1122;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro_Joystick {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        char [] cname= name.toCharArray();
        int cnt =0;
        boolean [] isA = new boolean[cname.length];

        //위아래 알파벳 갯수 최솟값 구하기. 및 왼오 갯수 체크를 위해 A일때 true;
        for(int i=0; i<cname.length;i++){
            if(cname[i] == 'A') { isA[i] =true; }
            else if( cname[i]<=78) cnt+= cname[i]-'A';
            else cnt += ('Z'-cname[i]+1);
        }

        int now = 0;
        //현재 위치에서 왼쪽에서 A가 아닌 것과 가장 가까운 거리 와 오른쪽에서 가장 가까운 거리 비교
        while(true){
            boolean check =true;
            for(int i=0; i<isA.length; i++){
                if(!isA[i]) {
                    check = false;
                    break;
                }
            }
            if(check) break;

            isA[now] =true; // 방문했다는 표시

            int rnext = now+1;
            int rdis = 1;
            while( true){
                if( rnext == cname.length) rnext = 0;
                if(isA[rnext]) {
                    rnext ++;
                    rdis ++;
                }else break;
            }
            int ldis =1;
            int lnext = now-1;
            while(true){
                if( lnext == -1) lnext = cname.length-1;
                if(isA[lnext]) {
                    lnext --;
                    ldis ++;
                }else break;
            }

            if( ldis < rdis){
                now = lnext;
                cnt += ldis;
            }else{
                now = rnext;
                cnt+=rdis;
            }
        }
        System.out.print(cnt);
    }
}

