package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    @Suppress("UNCHECKED_CAST")
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {

        val filteredResult = blockA.filter { it.javaClass == blockB.javaObjectType }
        if (filteredResult.isEmpty()) {
            return ""
        }
        return when (blockB) {
            Int::class -> (filteredResult as ArrayList<Int>).sum()
            LocalDate::class -> {
                val maxDate = (filteredResult as ArrayList<LocalDate>).max()!!
                maxDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            else -> filteredResult.joinToString("")
        }
    }
}
