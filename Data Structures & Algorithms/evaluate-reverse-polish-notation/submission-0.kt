class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<String>()
        for (token in tokens) {
            if (token != "+" && token != "-" && token != "*" && token != "/") {
                stack.push(token)
            } else {
                val val2 = stack.pop()
                val val1 = stack.pop()
                when (token) {
                    "+" -> {
                      stack.push((val1.toInt() + val2.toInt()).toString())  
                    }
                    "-" -> {
                        stack.push((val1.toInt() - val2.toInt()).toString())
                    }
                    "*" -> {
                        stack.push((val1.toInt() * val2.toInt()).toString())
                    }
                    "/" -> {
                        stack.push((val1.toInt() / val2.toInt()).toString())
                    }
                }
            }
        }
        return stack.pop().toInt()
    }
}
