/**
 * @packageName    :
 * @fileName       : Food_Fighter
 * @author         : yong
 * @date           : 4/15/25
 * @description    :
 */
fun main() {
    val arr: IntArray = intArrayOf(1,3,4,6)
    val result = Food_Fighter().solution(arr)
    println(result)
}
class Food_Fighter {
    fun solution(food: IntArray): String {
        var p1 = StringBuilder();
        var p2 = StringBuilder();

        for(i in 0..food.size - 1) {
            val useableFood = food[i]/2
            repeat(useableFood) {
                p1.append(i)
                p2.insert(0, i)
            }
        }

        return p1.toString() + 0 + p2.toString();
    }

}