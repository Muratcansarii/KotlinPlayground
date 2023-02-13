import java.util.Queue
import java.util.ArrayDeque

fun isMatch(s: String, p: String): Boolean {
    val stateStack: MutableList<State> = ArrayList(p.length)
    stateStack.add(State())
    var lastChar = ' '
    for (c in p) {
        when (c) {
            '*' -> {
                stateStack.removeLast()
                stateStack.last().addTransition(lastChar)
            }
            else -> {
                val newState = State()
                stateStack.last().addTransition(c, newState)
                stateStack.add(newState)
                lastChar = c
            }
        }
    }
    stateStack.last().accepted = true
    return stateStack.first().consume(s.toCollection(ArrayDeque()))
}

class State {
    private var anyTransition: State? = null
    private val transitions = mutableMapOf<Char, State>()
    var accepted = false

    fun addTransition(char: Char, target: State = this) = when (char) {
        '.' -> anyTransition = target
        else -> transitions[char] = target
    }

    fun consume(seq: Queue<Char>): Boolean {
        val next = seq.poll() ?: return accepted
        if (anyTransition?.consume(seq) == true) {
            return true
        }
        if (transitions[next]?.consume(seq) == true) {
            return true
        }
        return false
    }
}
