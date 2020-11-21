package YuJin.Algo_1122;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
    조합 할 수 있는 수를 모두 조합 한 후 소수인지 아닌지 판별 후 cnt 세기
 */
public class Pro_Finddecimal {

    private static  HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        String [] strings = numbers.split("");
        int [] nums = new int [strings.length];
        for(int i=0; i<strings.length; i++){ nums[i] =Integer.parseInt(strings[i]); }

        int cnt =0;

        for(int r=1; r<=nums.length;r++){
            int [] output = new int [r];
            boolean [] visited = new boolean[nums.length];
            perm(nums,output,visited,0,r);
        }

        for(int h: hashSet){
            System.out.println(h);
            if( decimal(h)) cnt++; }

        System.out.println(cnt);

    }

    //소수 찾기 메소드.
    public static boolean decimal(int n){
        int i;
        boolean check =true;

        if( n==0 || n==1) check =false;
        else{
            for( i=2; i<=Math.sqrt(n); i++){
                if(n%i == 0) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    //재귀함수를 사용하여 순열찾기
    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            String s="";
            for(int i: output){ s+=i; }
            hashSet.add(Integer.parseInt(s));
            return; }
        for (int i=0; i<arr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }
}

