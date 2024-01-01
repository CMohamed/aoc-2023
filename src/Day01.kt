import java.lang.Integer.min

fun main() {

    val numbers = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val numberMap = mapOf("one" to '1', "two" to '2', "three" to '3', "four" to '4',
            "five" to '5', "six" to '6', "seven" to '7', "eight" to '8', "nine" to '9')


    fun part1(input: List<String>): Int {
        var sum = 0
        for (x in input) {
            var s = ""
            //var first = '0'
            var last = '0'
            for (c in x) {
                if (c in '0'..'9') {
                    if (s.isEmpty()) s = s + c
                    last = c
                }
            }
            sum += (s + last).toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (x in input) {
            var s = ""
            var last = '0'
            for (i in x.indices) {
                var c = x[i]
                if (c in '0'..'9') {
                    if (s.isEmpty()) s += c
                    last = c
                } else {
                    // twone9klkvgdgh0seven
                    // yyoneighty
                    // 53977
                    var key = numberMap.keys.find { key -> x.substring(i, min(i+5, x.length)).contains(key) }
                    if (key == "one" && x.substring(i, min(i+5, x.length)) == "twone") {
                        key = "two"
                    }
                    var number = numberMap[key]
                    if (number != null) {
                        if (s.isEmpty()) s += number
                        last = number
                    }
                }
            }
            sum += (s + last).toInt()
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01_test")
    // check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
