package JunHo.kotlin

class ProK_Camouflage {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer: Int = 1
        val cloMap: HashMap<String, Int> = HashMap()

        for (clothe in clothes) cloMap[clothe[1]] = cloMap.getOrDefault(clothe[1], 0) + 1
        for (value in cloMap.values) answer *= (value + 1)

        return answer - 1;
    }
}