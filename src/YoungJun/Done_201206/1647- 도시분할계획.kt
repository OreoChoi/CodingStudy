import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine()!!.split(' ').map{ it.toInt() }
    val parent = IntArray(N + 1) {it}
    fun find(x : Int) : Int {
        if(parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }
    var k = N
    var sum = 0
    val arr = Array(M) {br.readLine()!!.split(' ').map {it.toInt()}.toList()}
    arr.sortedBy { it[2] }.forEach { (a,b,c) ->
        var x = find(a)
        var y = find(b)
        if(x != y) {
            parent[x] = y
            sum += c
            k--
        }
        if(k==2) {
            print(sum)
            return
        }
    }
}