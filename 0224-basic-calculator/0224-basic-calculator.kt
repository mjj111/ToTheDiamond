class Solution {
    fun calculate(s: String): Int {
        var result = 0
        var sign = 1
        var number = 0
        val stack = Stack<Int>()

        for (ch in s) {
            when {
                ch.isDigit() -> number = number * 10 + (ch - '0')
                ch == '+' -> {
                    result += sign * number
                    number = 0
                    sign = 1
                }
                ch == '-' -> {
                    result += sign * number
                    number = 0
                    sign = -1
                }
                ch == '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    result = 0
                    sign = 1
                }
                ch == ')' -> {
                    result += sign * number
                    number = 0
                    result *= stack.pop()
                    result += stack.pop()
                }
            }
        }
        return result + (sign * number)
    }
}