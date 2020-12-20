import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val INF = 0x7fffffff
    var V = nextInt()
    var E = nextInt()
    var St = nextInt()

    var graph = MutableList<MutableList<Pair<Int, Int>>>(30000) { mutableListOf() }

    for (i in 1..E) {
        var u = nextInt()
        var v = nextInt()
        var e = nextInt()
        graph[u].add(Pair(v, e))
    }

    var dist = MutableList<Int>(30000, { i -> INF })
    dist[St] = 0

    val comparator: Comparator<Pair<Int, Int>> = compareBy { it.second }
    var pq = PriorityQueue<Pair<Int, Int>>(comparator)


    pq.add(Pair(St, 0))

    while (pq.isNotEmpty()) {
        var cur = pq.peek()
        pq.remove()

        if (cur.second > dist[cur.first]) continue;

        graph[cur.first].forEach {
            if (dist[cur.first] + it.second < dist[it.first]) {
                dist[it.first] = dist[cur.first] + it.second;
                pq.add(Pair(it.first, dist[it.first]))
            }
        }
    }

    for (i in 1..V) {
        if (dist[i] == INF)
            println("INF")
        else
            println(dist[i])
    }

}