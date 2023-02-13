import org.omg.CORBA.Object


fun main(args: Array<String>) {
    val curInv = arrayListOf(
        arrayOf(21, "Bowling Ball"),
        arrayOf(1, "Hair Pin"),
        arrayOf(2, "Dirty Sock"),
        arrayOf(5, "Microphone")
    )
    val newInv = arrayOf(
        arrayOf(2, "Hair Pin"),
        arrayOf(3, "Half-Eaten Apple"),
        arrayOf(67, "Bowling Ball"),
        arrayOf(7, "Toothpaste")
    )

    val result = updateInventory(curInv as ArrayList<Array<Any>>,newInv as Array<Array<Any>>)

    //print out result
    for (element in result) {
        for (element2 in element) {
            print("$element2  ")
        }
        println()
    }
}


fun updateInventory(curInv: ArrayList<Array<Any>>, newInv: Array<Array<Any>>): ArrayList<Array<Any>> {
    //iterate second array
    for (newItem in newInv) {
        var found = false
        //check item: existed -> update amount
        for (curItem in curInv) {
            if (curItem[1] == newItem[1]) {
                found = true
                curItem[0] = curItem[0].toString().toInt() + newItem[0].toString().toInt()
            }
        }
        //not existed -> add new item
        if (!found) {
            curInv.add(newItem)
        }
    }

    //sort by alphabet
    curInv.sortBy { it[1] as Comparable<Any> }
    return curInv
}




