fun main(args:Array<String>) {
    val (R, C) = readLine()!!.split(" ").map{it.toInt()}
    val S = Array (R) { readLine()!! }

    fun go(x: Int, y: Int, bits: Int): Int {
        fun check(a: Int, b: Int): Int {
            if(0 <= a && a < R && 0 <= b && b < C) {
                val v = S[a][b] - 'a'
                if((bits shr v) and 1 == 0) {
                    return go(a, b, bits or (1 shl v)) + 1
                }
            }
            return 0
        }
        return listOf(check(x, y-1), check(x, y+1), check(x-1, y), check(x+1, y)).maxOrNull() ?: 0
    }

    println(go(0, 0, 1 shl (S[0][0] - 'a')) + 1)
}