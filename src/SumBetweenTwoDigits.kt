/**
 * @packageName    :
 * @fileName       : 두_정수_사이의합
 * @author         : yong
 * @date           : 4/15/25
 * @description    :
 */
fun main() {
    val result = SumBetweenTwoDigits().solution(3, 5)
    println(result)
}

class SumBetweenTwoDigits {

    fun solution(a: Int, b: Int): Int {
        var value: Int = 0
        if(a > b) {
            for(i in b..a) {
                value += i;
            }
        } else {
            for(i in a..b) {
                value += i;
            }
        }
        return value
    }
}