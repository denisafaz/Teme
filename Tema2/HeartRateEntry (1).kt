data class HeartRateEntry(val date:Long, val value: Int)

fun populateData(vararg dataPair: Pair<Long, Int>): List<HeartRateEntry> = dataPair.map {HeartRateEntry(it.first, it.second)}

val data =populateData (
        1612310400L to 76,
        1612310400L to 89,
        1612310400L to 44,
        1612224000L to 47,
        1612224000L to 115,
        1612224000L to 87,
        1612137600L to 60,
        1612137600L to 167)

fun main() {

    //1
    println(data.minBy { T -> T.value }?.value);

    //2
    println(data.sumBy { T-> T.value } / data.size);

    //3
    data.filter{ T -> T.value > 100 }.forEach { heartRateEntry: HeartRateEntry -> println(heartRateEntry.value) }

    //4
    data.groupBy { it.date }.map { entry: Map.Entry<Long, List<HeartRateEntry>> ->
        val key = entry.key
        print("$key [ ")
        for (a in entry.value) {
            val value = a.value
            print("$value ")
        }
        println("]") }

    //5
    data.groupBy { T->T.date }.map { entry -> println(entry.value.maxBy { T-> T.value }?.value) }
}