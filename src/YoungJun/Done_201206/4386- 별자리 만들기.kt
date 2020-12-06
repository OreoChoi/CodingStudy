import kotlin.math.*

fun main() {
    val N = readLine()!!.toInt()
    val starLoc = ArrayList<Pair<Double,Double>>()
    val list = ArrayList<Triple<Double,Int,Int>>()
    val parent = Array(N + 1){it}
    repeat(N) {
        val (x,y) = readLine()!!.split(' ').map{it.toDouble()}
        starLoc.add(Pair(x,y))
    }
    for(i in 0..N-1) {
        val (x,y) = starLoc[i]
        for(j in i+1..N-1) {
            val (x2,y2) = starLoc[j]
            list.add(Triple(sqrt((x2 - x).pow(2) + (y2 - y).pow(2)),i,j))
        }
    }

    fun find(x : Int):Int {
        if(parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    var sum : Double = 0.0
    list.sortedBy { it.first }.forEach{(c,a,b) ->
        val x = find(a)
        val y = find(b)
        if (x != y) {
            parent[x] = y
            sum += c
        }
    }
    print(sum)
}