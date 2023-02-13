

fun staircase(n: Int): Unit {
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (j < n - 1 - i) {
                print(" ")
            } else {
                print("#")
            }
        }
        println()
    }

}