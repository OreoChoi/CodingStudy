package JunHo;

import java.io.*;


/**
 * jhChoi - 201112
 * 차량 번호판
 */
public class CarNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] nums = br.readLine().toCharArray();

        int sum = 1;
        int dupliCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dupliCount++;
                continue;
            }

            sum *= mul(nums[i - 1], dupliCount);
            dupliCount = 1;
        }

        sum *= mul(nums[nums.length - 1], dupliCount);
        bw.write(sum + "");
        bw.flush();
    }

    public static int mul(char num, int dupliCount) {
        int mul = num == 'c' ? 26 : 10;
        int deCount;
        if (dupliCount > 1) {
            deCount = (int) Math.pow(num == 'c' ? 25 : 9, dupliCount - 1);
            mul = mul * deCount;
        }
        return mul;
    }
}
