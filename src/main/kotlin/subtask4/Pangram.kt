package subtask4

class Pangram {

    fun getResult(inputString: String): String {

        val operationalString = inputString.trim()

        if (operationalString.isEmpty()) {
            return ""
        }
        return if (isPangram(operationalString)) fetchResult(
            operationalString,
            LettersType.VOWELS
        ) else fetchResult(operationalString)
    }

    private fun fetchResult(
        input: String,
        usedLetters: LettersType = LettersType.CONSONANTS
    ): String {

        return input.split(SPACES_REGEX.toRegex())
            .map { word ->
                var vowelsCount = 0
                val stringBuilder = StringBuilder()

                for (c in word.trim()) {
                    stringBuilder.append(
                        if (usedLetters.lettersSet
                                .contains(c, true)
                        ) {
                            vowelsCount++
                            c.toUpperCase()
                        } else {
                            c
                        }
                    )
                }
                stringBuilder.insert(0, vowelsCount).toString()
            }
            .sortedBy { it.first() }
            .joinToString(" ")
    }

    private fun isPangram(input: String): Boolean {

        val lettersSet = mutableSetOf<String>()
        for (c in input.toLowerCase()) {
            if (c in LettersType.ALL.lettersSet) {
                lettersSet.add(c.toString())
            }
        }
        val joinedString = lettersSet
            .sorted()
            .joinToString("")

        return joinedString == LettersType.ALL.lettersSet
    }

    private enum class LettersType(val lettersSet: String) {

        ALL("abcdefghijklmnopqrstuvwxyz"),
        VOWELS("aeiouy"),
        CONSONANTS("bcdfghjklmnpqrstvwxz")
    }

    companion object {
        const val SPACES_REGEX = "\\s+"
    }
}
