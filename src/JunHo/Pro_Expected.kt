package JunHo

fun main(args: Array<String>) {
    val expected: Pro_Expected = Pro_Expected()
    println(expected.solution(16, 1, 8)) //success
    println(expected.solution(16, 1, 9)) //success
    println(expected.solution(16, 2, 8)) //success
    println(expected.solution(16, 3, 8)) //success
    println(expected.solution(16, 4, 8)) //success
    println(expected.solution(16, 5, 8)) //fail
    println(expected.solution(16, 6, 8)) //fail
    println(expected.solution(16, 7, 8)) //fail
   /* println(expected.solution(16, 9, 8)) //success
    println(expected.solution(16, 10, 8)) //success
    println(expected.solution(16, 11, 8)) //success
    println(expected.solution(16, 12, 8)) //success
    println(expected.solution(16, 13, 8)) //success
    println(expected.solution(16, 14, 8)) //success
    println(expected.solution(16, 15, 8)) //success
    println(expected.solution(16, 16, 8)) //success*/
   /* println(expected.solution(16, 1, 16)) //success
    println(expected.solution(16, 2, 16)) //success
    println(expected.solution(16, 3, 16)) //success
    println(expected.solution(16, 4, 16)) //success
    println(expected.solution(16, 5, 16)) //success
    println(expected.solution(16, 6, 16)) //success
    println(expected.solution(16, 7, 16)) //success
    println(expected.solution(16, 8, 16)) //success
    println(expected.solution(16, 9, 16)) //success
    println(expected.solution(16, 10, 16)) //success
    println(expected.solution(16, 11, 16)) //success
    println(expected.solution(16, 12, 16)) //success
    println(expected.solution(16, 13, 16)) //success
    println(expected.solution(16, 14, 16)) //success
    println(expected.solution(16, 15, 16)) //success*/
}

/**
 * 예시1)
 * 총 16팀 8번 9번
 *
 * 0라운드
 * 1 2 3 4 5 6 7 8 | 9 10 11 12 13 14 15 16
 * 8개 팀씩 남음
 *
 * 1라운드 8번팀은 홀수가 아니므로 아직 만나지 않았다.
 * l(4) = (8+1)/2  //8번팀은 4번팀이 된다
 * r(5) = (9+1)/2  //9번팀은 5번팀이 된다.
 *
 * 1 2 3 4 | 5 6 7 8
 * 4개 팀씩 남음
 *
 * 2라운드 4번팀은 홀수가 아니므로 아직 만나지 않는다.
 * l(2) = (4+1)/2
 * r(3) = (5+1)/2
 *
 * 1 2 | 3 4
 * 2개팀씩
 *
 * 3라운드 2번팀은 홀수가 아니므로 아직 만나지 않는다.
 * l(1) = (2+1)/2
 * r(2) = (3+1)/2
 *
 * 1 | 2
 *
 * 4라운드 1번팀이 홀수고 2번팀이 다음팀이므로 경기를 시작한다.
 *
 * 예시2)
 *
 * 8팀 1번 8번
 *
 * 0라운드
 * 1 2 3 4 | 5 6 7 8
 * 4개 팀씩 남음
 *
 * 1라운드 1번팀은 홀수지만 8번팀이 다음경기가 아니다
 * l(1) = (1+1)/2
 * r(4) = (8+1)/2
 *
 * 1 2 | 3 4
 * 2개 팀씩 남음
 *
 * 2라운드 1번팀은 홀수지만 4번팀은 다음경기가 아니다
 * l(1) = (1+1)/2
 * r(2) = (4+1)/2
 *
 * 1 | 2
 * 1개 팀씩 남음
 * 3라운드 1번팀은 홀수고 2번팀은 다음팀이다 경기를 시작한다.
 * * */
class Pro_Expected {
    fun solution(n: Int, a: Int, b: Int): Int {
        var l = a.coerceAtMost(b)
        var r = a.coerceAtLeast(b)
        var answer = 1

        while (true) {  //경기가 끝날때까지 순회
            if(l%2 == 1 && r-l == 1)break   //좌측팀은 홀수여야하며, 좌측팀과 우측팀의 거리가 1이여야한다. (둘이 만나야한다는 야기)
            l = (l+1)/2                     //한라운드당 참가자를 반씩 줄어들게 한다.
            r = (r+1)/2
            answer++
        }

        return answer
    }
}

