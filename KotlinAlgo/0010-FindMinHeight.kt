fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) {
        return listOf(0)
    }

    val lookup = (0..<n).associateWithTo(LinkedHashMap()) { mutableSetOf<Int>() }

    for ((l, r) in edges) {
        lookup[l]!!.add(r)
        lookup[r]!!.add(l)
    }

    var updateEdges = (0..<n).toSet()
    var lastUpdateEdges = updateEdges

    while (updateEdges.isNotEmpty()) {
        val singleEdges = mutableListOf<Pair<Int, Int>>()
        for (key in updateEdges) {
            lookup[key]?.let { con ->
                if (con.size == 1) {
                    singleEdges.add(key to con.first())
                }
            }
        }
        lastUpdateEdges = updateEdges
        updateEdges = mutableSetOf()

        for ((key, con) in singleEdges) {
            lookup.remove(key)
            lookup[con]?.remove(key)
            updateEdges.add(con)
        }
    }

    return lastUpdateEdges.sorted()
}
