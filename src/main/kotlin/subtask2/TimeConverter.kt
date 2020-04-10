package subtask2

import java.time.LocalTime

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {

        val time = try {
            LocalTime.of(hour.toInt(), minute.toInt())
        } catch (e: Exception) {
            return ""
        }
        val words = getWords()
        val h = time.hour

        return when (val m = time.minute) {
            0 -> "${words[h]} o' clock"
            1 -> "${words[m]} minute past ${words[h]}"
            15 -> "quarter past ${words[h]}"
            30 -> "half past ${words[h]}"
            45 -> "quarter to ${words[h + 1]}"
            in 1..30 -> "${words[m]} minutes past ${words[h]}"
            else -> "${words[60 - m]} minutes to ${words[h + 1]}"
        }
    }

    private fun getWords(): Map<Int, String> {

        return mapOf(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine",
            10 to "ten",
            11 to "eleven",
            12 to "twelve",
            13 to "thirteen",
            14 to "fourteen",
            15 to "fifteen",
            16 to "sixteen",
            17 to "seventeen",
            18 to "eighteen",
            19 to "nineteen",
            20 to "twenty",
            21 to "twenty one",
            22 to "twenty two",
            23 to "twenty three",
            24 to "twenty four",
            25 to "twenty five",
            26 to "twenty six",
            27 to "twenty seven",
            28 to "twenty eight",
            29 to "twenty nine"
        )
    }
}
