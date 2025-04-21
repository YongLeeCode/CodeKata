/**
 * @packageName    :
 * @fileName       : 모의고사
 * @author         : yong
 * @date           : 4/21/25
 * @description    :
 */
fun main() {

    val va = intArrayOf(1,2,3,4,5)
    모의고사().solution(va)
}
class 모의고사 {
    private val studentAns = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
        intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
    fun solution(answers: IntArray): IntArray {

        val cnt = IntArray(3)
        studentAns.forEachIndexed { i, std ->
            cnt[i] = answers.filterIndexed { j, ans -> ans == std[j % std.size] }.count()
        }
        println(cnt.contentToString())

        val result = mutableListOf<Int>()
        for(i in 0 until cnt.size) {
            if(cnt.maxOrNull() == cnt[i]) {
                result.add(i+1)
            }
        }

        return result.toIntArray()
    }
}