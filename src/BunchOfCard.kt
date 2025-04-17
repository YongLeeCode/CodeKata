/**
 * @packageName    : PACKAGE_NAME
 * @fileName       : BunchOfCard
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
fun main() {
    val cards1: Array<String> = arrayOf("i", "water", "drink")
    val cards2: Array<String> = arrayOf("want", "to")
    val goal: Array<String> = arrayOf("i", "want", "to", "drink", "water")
    print(BunchOfCard().solution(cards1, cards2, goal))
}

class BunchOfCard {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var currCard1: Int = 0
        var currCard2: Int = 0

        for (i in 0 until goal.size) {
			if(currCard1 < cards1.size &&cards1[currCard1].equals(goal[i])) {
                currCard1++
            } else if(currCard2 < cards2.size && cards2[currCard2].equals(goal[i])) {
                currCard2++
            } else {
                return "No"
            }
        }

        return "Yes"
    }
}
