class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c)
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false
                val open = stack.pop()
                if (open == '(' && c != ')') return false
                if (open == '[' && c != ']') return false
                if (open == '{' && c != '}') return false
            }
        }

        return stack.isEmpty()
    }
}
