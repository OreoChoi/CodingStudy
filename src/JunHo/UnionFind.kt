package JunHo

/**
 * UnionFind kotlin ver.
 * */
class UnionFind(val size: Int) {
    private val parent: IntArray = IntArray(size + 1)

    init {
        for (i in 1 until parent.size) parent[i] = i
    }

    fun find(x: Int): Int {
        if (parent[x] == x) {
            return x
        } else {
            parent[x] = find(parent[x])
            return parent[x]
        }
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return
        parent[rootY] = rootX
    }
}