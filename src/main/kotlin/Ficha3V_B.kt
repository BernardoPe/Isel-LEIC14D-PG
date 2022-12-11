import java.util.EventListener
data class Seq(val data: List<Int>)

fun main() {
    //EX 1
    val source0 = listOf(3,4,1)
    val source1 = listOf(2,2)
    val source2 = listOf(2,3,9)
    val list = listOf(3,3,4,1,5,4,1,3,4,1,2,2,2)
    val occurrences0 = search(list, source0)
    if (occurrences0.size > 0)
        println(occurrences0)
    else
        println("Empty")


    //EX 2
    val subseq0 = Seq(listOf(3,4,1))
    val subseq1 = Seq(listOf(2,2))
    val subseq2 = Seq(listOf(2,3,9))
    val seq = Seq(listOf(3,3,4,1,5,4,1,3,4,1,2,2,2))
    val occurrences2 = seq.search(subseq0)
    if (occurrences2.size > 0)
        println(occurrences2)
    else
        println("Empty")
}

//EX 1
fun search(list : List<Int> , source : List<Int>) : List<Pair> {
    var pairList: List<Pair> = emptyList()
    var checkedPair = listOf<Int>()
    val grupos = list.size / source.size
    val checkamount = grupos * 2 - 1
    for (initid in 0 ..checkamount) {
        val lastid = initid + source.size - 1
        for(iterator in initid..lastid){
            checkedPair += list[iterator]
            if(checkedPair == source){
                pairList += Pair(initid, iterator)
            }
        }
        checkedPair = listOf()
    }
    return pairList
}


//EX2
fun equalSequencesFromIndex(seq: Seq, subSeq: Seq, idx: Int) : Boolean{
    var checkList = listOf<Int>()
    if(idx + subSeq.data.size - 1 in seq.data.indices) {
        for (id in idx..idx + subSeq.data.size - 1) {
            checkList += seq.data[id]
            if (checkList == subSeq.data) return true
        }
    }
    return false
}

fun Seq.search(subSeq: Seq): List<Pair> {
    var pairList : List<Pair> = emptyList()
    for(initid in 0..this.data.size){
        if(equalSequencesFromIndex(this,subSeq,initid)){
            pairList += Pair(initid, initid + subSeq.data.size -1)
        }
    }
    return pairList
}


