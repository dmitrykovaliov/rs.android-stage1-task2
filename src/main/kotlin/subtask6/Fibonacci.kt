package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {

        var f1 = 0
        var f2 = 1
        var mult = 0

        while (mult < n) {
            val sum = f1 + f2
            f1 = f2
            f2 = sum
            mult = f1 * f2
        }
        return if (mult == n) {
            intArrayOf(f1, f2, 1)
        } else {
            intArrayOf(f1, f2, 0)
        }
    }
}
