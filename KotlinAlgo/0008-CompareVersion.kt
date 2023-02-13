val regex = "(?<=[.])?\\d+(?=[.])?".toRegex()

fun compareVersion(version1: String, version2: String): Int {
    println("Version1: $version1, Version2: $version2")
    (regex.findAll(version1).map { it.value.toInt() } + generateSequence { -1 })
        .zip(regex.findAll(version2).map { it.value.toInt() } + generateSequence { -1 })
        .forEach { (l, r) ->
            if (l == -1 && r == -1) {
                return 0
            }

            val nl = l.coerceAtLeast(0)
            val nr = r.coerceAtLeast(0)

            if (nl < nr) {
                return -1
            } else if (nr < nl) {
                return 1
            }
        }
    return 0
}
