

fun rotateMatrix(matrix: MutableList<MutableList<Int>>) {
    val length = matrix.size - 1
    for (layer in 0 until matrix.size / 2) {
        val last = length - layer
        for (i in layer until last) {
            val offset = i - layer
            var top = matrix[layer][i]
            // left -> top
            matrix[layer][i] = matrix[last - offset][layer]
            // bottom -> left
            matrix[last - offset][layer] = matrix[last][last - offset]
            // right -> bottom
            matrix[last][last - offset] = matrix[i][last]
            // top -> right
            matrix[i][last] = top
        }
    }
}


private const val SIZE = 10

fun main() {
    val matrix = MutableList(SIZE) { col ->
        MutableList(SIZE) { row ->
            (row * col) % 10
        }
    }

    printMatrix(matrix)
    rotateMatrix(matrix)
    println("\nRotated")
    printMatrix(matrix)

}

private fun printMatrix(matrix: MutableList<MutableList<Int>>) {
    println("MATRIX:\n${matrix.joinToString("\n")}")
}