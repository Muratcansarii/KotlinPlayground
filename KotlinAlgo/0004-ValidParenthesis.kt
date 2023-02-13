fun isValidParenthesis(s: String): Boolean {
    val stack = ArrayDeque<Char>(s.length / 2)
    for (c in s) {
        if (c == '(' || c == '[' || c == '{') {
            stack.add(c)
        } else {
            val last = stack.removeLastOrNull() ?: return false
            if ((c == ')' && last != '(') ||
                (c == ']' && last != '[') ||
                (c == '}' && last != '{') ) {
                return false
            }
        }
    }
    return stack.isEmpty()
}
