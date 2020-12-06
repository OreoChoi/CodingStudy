import java.lang.Integer.*

fun main() {
    val (N,M) = readLine()!!.split(' ').map { it.toInt() }
    val arr = Array(N) {readLine()!!}
    val dp = Array(N) {IntArray(M) {0} }
    var ans = 0
    for(i in 0 until N) for(j in 0 until M) if(arr[i][j] == '1') {
        dp[i][j] = 1
        ans = 1
    }
    for(i in 1 until N) for(j in 1 until M) if(arr[i][j] == '1') {
        dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
        ans = max(ans, dp[i][j])
    }
    print(ans * ans)
}