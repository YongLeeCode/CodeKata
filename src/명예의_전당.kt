/**
 * @packageName    :
 * @fileName       : 명예의_전당
 * @author         : yong
 * @date           : 4/16/25
 * @description    : https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */
fun main() {
    val score: IntArray = intArrayOf(10, 100, 20, 150, 1, 100, 200)
    println(Solution().solution(3, score).contentToString())
}
class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        // for loop
        // 조건문 1 k보다 명예의 전당 수가 적을 시
            // 마지막 전당의 index를 -> answer에 넣기
        // 조건문 2 k보다 많거나 같을 시
            // 마지막 전당의 k-1 인덱스를 -> answer에 넣기

        val ranking = mutableListOf<Int>()
        val answer = mutableListOf<Int>()

        for(s in score) {
            ranking.add(s)
            ranking.sortDescending()

            if(ranking.size > k) {
                ranking.removeLast()
            }

            answer.add(ranking.last())
        }

        return answer.toIntArray()
    }
}