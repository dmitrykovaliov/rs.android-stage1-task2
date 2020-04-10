package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        val regex = buildRegex(b)

        return if (a.matches(regex)) "YES" else "NO"
    }

    private fun buildRegex(word: String): Regex {

        val stringBuilder = StringBuilder()

        with(stringBuilder) {
            for (c in word) {
                append(ZERO_OR_MORE_CHARACTERS_REGEX)
                append(c)
            }
            append(ZERO_OR_MORE_CHARACTERS_REGEX)
        }


        return "$stringBuilder".toRegex(RegexOption.IGNORE_CASE)
    }

    companion object {
        const val ZERO_OR_MORE_CHARACTERS_REGEX = ".*"
    }
}
