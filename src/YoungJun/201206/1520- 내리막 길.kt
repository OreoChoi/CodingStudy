import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(1,-1,0,0)
val dy = arrayOf(0,0,1,-1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,M) = readLine()!!.split(' ').map{it.toInt()}
    val arr = Array(N) {readLine()!!.split(' ').map{it.toInt()}}
    val dp = Array(N) {Array(M) {-1}}

    fun go(x : Int, y : Int) : Int {
        if(x == M - 1 && y == N - 1) return 1
        if(dp[y][x] != -1) return dp[y][x]
        var sum = 0
        for(i in 0..3) {
            val nx = dx[i] + x
            val ny = dy[i] + y
            if(nx<0 || ny<0 || nx==M || ny==N || arr[ny][nx] >= arr[y][x]) continue;
            sum += go(nx, ny)
        }
        dp[y][x] = sum
        return dp[y][x]
    }
    print(go(0,0))
}