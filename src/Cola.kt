/**
 * @packageName    :
 * @fileName       : Cola
 * @author         : yong
 * @date           : 4/16/25
 * @description    :
 */
fun main() {
 println(Cola().solution(2, 1, 20))
}
class Cola {
    fun solution(a: Int, b: Int, n: Int): Int {
        var emptyBottle = n
        var takenCola = 0
        //while loop으로 n이 a개 이상인지 확인
        //n을 a로 나눈 후 b로 곱한다
        //나온 값을 저장
        //n은 남은 콜라병 저장
        while(emptyBottle >= a) {
            takenCola += emptyBottle / a * b
            emptyBottle = (emptyBottle / a * b) + (emptyBottle % a)
            println(emptyBottle)
        }

        return takenCola
    }
}
