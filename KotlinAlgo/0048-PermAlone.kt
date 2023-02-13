

fun main(args: Array<String>) {
    val result = permAlone("abcdefa")
    println("The number of total permutations of the provided string that don't have repeated consecutive letters: $result")
}

fun permAlone (string: String): Int {
    //regex to match repeated consecutive characters
    val regex = Regex("([a-z])\\1")

    //slice the input string into list
    val listChar = string.toCharArray().toMutableList()
    val permutations = mutableListOf<String>()
    var filter = mutableListOf<String>()
    var temp: Char

    fun swap(index1: Int, index2: Int) {
        temp = listChar[index1]
        listChar[index1] = listChar[index2]
        listChar[index2] = temp
    }

    /**
     * generate list of permutations using Heap's algorithms https://en.wikipedia.org/wiki/Heap%27s_algorithm
     * @paramL size: size of the list and the list itself (listChar)
     * @return: list of permutations (permutations)
     */
    fun generate(size: Int) {
        if (size == 1) {
            permutations.add(listChar.joinToString(""))
        } else {
            //Generate permutations for kth swapped with each k-1 initial
            for (i in 0 until size) {
                generate(size-1)
                //Swap choice dependent on parity of k (even or odd)
                if ((size % 2) == 0) {
                    swap(i, size-1)
                } else {
                    swap(0, size-1)
                    //println(listChar)
                }
            }
        }
    }

    fun printFilter() {
        for (item in filter) {
            println(item)
        }
    }

    generate(string.length)
    //filter using regex
    filter = permutations.filter {
        !regex.containsMatchIn(it)    } as MutableList<String>
    //print list of permutations of the provided string that don't have repeated consecutive letters but do not hanlding duplicated string
    printFilter()
    //printList()
    return filter.size

}

