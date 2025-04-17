/**
 * @packageName    :
 * @fileName       : Year2016
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
fun main() {
    println(Year2016().solution(5, 24))
}
class Year2016 {
    fun solution(a: Int, b: Int): String {
        val day : Map<Int, String> = mapOf(
            0 to "FRI",
            1 to "SAT",
            2 to "SUN",
            3 to "MON",
            4 to "TUE",
            5 to "WED",
            6 to "THU"
        )
        val monthDay: List<Int> = listOf(31, 29, 31, 30, 31, 30, 31,31, 30, 31, 30, 31)
        var days: Int = 0

        for(i in 0 until a - 1) {
            days += monthDay[i]
        }
        days += b - 1

        return day.get(days%7).toString()
    }
}