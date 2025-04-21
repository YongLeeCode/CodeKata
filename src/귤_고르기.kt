/**
 * @packageName    :
 * @fileName       : 귤_고르기
 * @author         : yong
 * @date           : 4/20/25
 * @description    :
 */
fun main() {
    val tangerine: IntArray = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    println(귤_고르기().solution(6, tangerine))
}

class 귤_고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {

        val countArr = IntArray(10000001)

        tangerine.forEach {
            countArr[it]++
        }

        countArr.sortDescending()

        var rest = k
        var ans = 0
        for (i in countArr.indices) {
            if (rest == 0) {
                break
            }

            val quantity = countArr[i]

            if (quantity <= rest) {
                ans++
                rest -= quantity
            } else {
                ans++
                rest = 0
                break
            }

        }

        return ans
    }
    }