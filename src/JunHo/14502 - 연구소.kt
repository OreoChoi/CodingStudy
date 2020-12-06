val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

const val MAX_WALL = 3
const val EMPTY = 0
const val WALL = 1
const val VIRUS = 2
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }   //연구소 세로, 가로 크기
    val map = Array(N) { Array(M) { 0 } }                             //연구소를 표현할 map

    for (i in 0 until N) {                                            //연구소 input
        val line = readLine().split(" ").map { it.toInt() }
        for (j in 0 until M) map[i][j] = line[j]
    }

    println(buildWall(map, 0).toString())
}

//벽을 3개 세웁니다.
fun buildWall(map: Array<Array<Int>>, step: Int): Int {
    if (step == MAX_WALL) return getSafeArea(map)  //벽이 3개 세워지면, 안전지대가 얼마나 있는지 파악하기 위해 getSafeArea를 실행합니다.

    var safe = -1                                  //바이러스 안전 지역 수
    for (i in map.indices) {                       //맵 전체를 순회
        for (j in map[i].indices) {
            if (map[i][j] == EMPTY) {              //벽이 안 세워진 곳 이면 벽을 세움
                map[i][j] = WALL
                safe = Math.max(buildWall(map, step + 1), safe) //벽을 세우기를 재귀호출합니다.
                map[i][j] = EMPTY                  //벽을 다시 허뭅니다.
            }
        }
    }
    return safe
}

//안전 지대를 count 한뒤 반환 합니다.
fun getSafeArea(map: Array<Array<Int>>): Int {
    var area = 0
    val copyMap = copy(map)      //현재 맵을 복사

    for (i in copyMap.indices) { //복사 맵을 전체 순회
        for (j in copyMap[i].indices) {  //복사맵에서 바이러스인 부분을 확산시킵니다.
            if (copyMap[i][j] == VIRUS) spreadVirus(copyMap, i, j)
        }
    }

    copyMap.forEach { it.forEach { i -> if (i == EMPTY) area++ } }   //벽이 세워진 copyMap에서 얼만큼의 안전지대가 있는지 체크 후 반환합니다.
    return area
}

//바이러스를 확산 시킵니다.
fun spreadVirus(map: Array<Array<Int>>, x: Int, y: Int) {
    for (i in 0 until 4) {  //상하좌우 바이러스를 퍼뜨릴수 있는지 확인 후 바이러스를 확산합니다.
        val ax = x + dx[i]
        val ay = y + dy[i]
        if (isInRange(ax, ay, map.size, map[0].size) && map[ax][ay] == EMPTY) { //index가 연구소 내부 이며, 확산 가능 공간(0)인 경우
            map[ax][ay] = VIRUS
            spreadVirus(map, ax, ay) //재귀 형태로 연관된 지역에 바이러스를 뿌리러 갑니다
        }
    }
}

//연구소 내부 범위인지 체크합니다.
fun isInRange(x: Int, y: Int, N: Int, M: Int): Boolean {
    return (x in 0 until N) && (y in 0 until M)
}

//map을 복사합니다.
fun copy(map: Array<Array<Int>>): Array<Array<Int>> {
    val newArr = Array(map.size) { Array(map[0].size) { 0 } }

    for (i in map.indices) {
        for (j in map[i].indices) {
            newArr[i][j] = map[i][j]
        }
    }
    return newArr
}