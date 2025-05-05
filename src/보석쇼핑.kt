import java.util.LinkedList
import java.util.Queue

fun main() {

    val gems: Array<String> = arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    Solution().solution(gems)
}

class Solution() {
    fun solution(gems: Array<String>): IntArray {
        val map = HashMap<String, Int>()
        val queue: Queue<String> = LinkedList()

        for (gem in gems) {

                map.put(gem, map.get(gem)?.plus(1) ?: 1)
                queue.add(gem)


            while ((map[queue.peek()] ?: 0) > 1) {
                val removed = queue.poll()
                map[removed] = (map[removed] ?: 1) - 1
            }
        }
        println()
        return intArrayOf(1)
    }

//    // 모든 보석 존재하는지 확인 1.
//    // 앞에 보석이 나왔을 때, 뒤에 보석이 추가된다.
//    // 앞에 보석이 나왔을 때, 만약 그 다음 보석을 두 개 이상 가지고 있으면 그것도 없앤다.
//    // 보석 끝 - 시작이 이전보다 작은 경우 앞에 숫자 삭제
//    //
//
//    var answer = intArrayOf()
//    return answer

}