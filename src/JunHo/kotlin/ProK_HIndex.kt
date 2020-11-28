package JunHo.kotlin

fun main(args:Array<String>) {
    val solution:ProK_HIndex = ProK_HIndex()
    val citations: Array<Int> = arrayOf(3, 0, 6, 1, 5)

    println(solution.solution(citations))
}

class ProK_HIndex {
    public fun solution(array: Array<Int>): Int {
        var H: Int = 0
        var cit:Array<Int> =  array.sortedArray()

        if (cit[cit.lastIndex] == 0) return 0

        for (i in 1..cit.size){

        }

        return H
    }
}