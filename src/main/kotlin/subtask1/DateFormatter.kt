package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        val localDate = try {
            LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: Exception) {
            return "Такого дня не существует"
        }
        val dateTimeFormatter = DateTimeFormatter
            .ofPattern("dd MMMM, EEEE", Locale("ru", "RU"))

        return localDate.format(dateTimeFormatter)
    }
}
