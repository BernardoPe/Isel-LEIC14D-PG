
data class Pair(val first: Int, val second: Int)
data class Group(val data : List<Int>)

fun main() {
    val g0 =listOf(Group(listOf(3,4,1)) ,Group(listOf(1,2,3)),Group(listOf(5,4,1)),Group(listOf(3,4,1)), Group(listOf(2,2,2))) // 2 alinea C
    val g1 = listOf(3,4,1,1,2,3, 5,4,1, 1,2,3,3,4,1, 2,2,2)
    val g2 = listOf<Int>(3,4,1, 1,3,4, 2,2,2)
    val occurrences0 = findRepeatedGroups2(g0) // 2 alinea C
    val occurrences1 = findRepeatedGroups(g1,3)
    val occurrences2 = findRepeatedGroups(g2,3)
    if (occurrences0.size > 0)
        println(occurrences0)
    else
        println("Empty")

    if (occurrences1.size > 0)
        println(occurrences1)
    else
        println("Empty")

    if (occurrences2.size > 0)
        println(occurrences2)
    else
        println("Empty")

    println(Group(listOf(3,4,1)).equals2(Group(listOf(3,3,4,5,3,4,1))))
    println(Group(listOf(3,4,1)).equals2(Group(listOf(4,3,1))))
}

fun findRepeatedGroups(groups: List<Int>, size: Int): List<Pair> { //EX 1
    var pairList: List<Pair> = emptyList()
    var initialPair = listOf<Int>()
    var checkedPair = listOf<Int>()
    val grupos = groups.size / size
    for (initid in 0 ..grupos - 1) {
        for (checkid in initid + 1..grupos-1 ) {
            val firstid = initid * size
            val lastid = checkid * size
            for (iterator in 0..size - 1) {
                initialPair += groups[firstid + iterator]
                checkedPair += groups[lastid + iterator]
                if (initialPair.size == size && initialPair == checkedPair )
                    pairList += Pair(firstid, lastid)
            }
            initialPair = listOf()
            checkedPair = listOf()
        }
    }
    return pairList
}

fun findRepeatedGroups2(groups : List<Group>) : List<Pair> { //EX 2 ALINEA B
    var pairList = listOf<Pair>()
        for (initid in 0..groups.size - 1) {
            val grouplength = groups[initid].data.size
                for (checkid in initid+1..groups.size - 1) {
                            if (groups[initid].equals2(groups[checkid])) {
                                val Pair = Pair(initid * grouplength, checkid * grouplength)
                                pairList += Pair
                            }
                }
        }
    return pairList
}

fun Group.equals2(other : Group) : Boolean = this.data.size == other.data.size && false !in this.data.map{it in other.data}
//EX 2 ALINEA A




