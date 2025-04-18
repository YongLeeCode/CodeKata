/**
 * @packageName    :
 * @fileName       : FruitMarket
 * @author         : yong
 * @date           : 4/18/25
 * @description    :
 */
fun main() {
    val score: IntArray = intArrayOf(1, 2, 3, 1, 2, 3, 1)
    println(FruitMarket().solution(3, 4, score))
}
class FruitMarket {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        val remain: Int = score.size %  m
        val qualityScore = score.sortedArray()

        var score = 0
        for(i in remain until qualityScore.size step m) {
            score += qualityScore[i] * m
            println(score)
        }

        return score
    }
}