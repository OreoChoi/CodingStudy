import java.lang.Integer.min

fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        val N = readLine()!!.toInt()
        val arr = readLine()!!.split(' ').map{it.toInt()}
        val dp = Array(N + 1) {IntArray(N + 1) {-1}}
        val sum = Array(N + 1) {0}

        for(i in 1..N) sum[i] = sum[i-1] + arr[i-1]

        fun go(le : Int, ri : Int) : Int {
            if(dp[le][ri] != -1) return dp[le][ri]
            if(le == ri) return 0
            if(ri - le == 1) return arr[le - 1] + arr[ri - 1];

            dp[le][ri] = 2e9.toInt()
            for(mid in le until ri)
                dp[le][ri] = min(dp[le][ri], go(le, mid) + go(mid + 1, ri))

            dp[le][ri] += sum[ri] - sum[le - 1]
            return dp[le][ri]
        }
        println(go(1, N))
    }
}