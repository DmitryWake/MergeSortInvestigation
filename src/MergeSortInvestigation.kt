import java.lang.ref.Cleaner
import kotlin.math.abs
import kotlin.random.Random

class MergeSortInvestigation {

    private val random = Random(System.currentTimeMillis())

    private fun generateList(size: Int): List<Int> {
        return List(size) {
            random.nextInt()
        }
    }

    fun investigate(testsCount: Int, startSize: Int = 10, stepSize: Int = 10): List<Long> {
        val result = mutableListOf<Long>()

        for (i in 0 until testsCount) {
            val size = startSize + i * stepSize

            result.add(testList(generateList(size)))
        }

        return result
    }

    private fun testList(list: List<Int>): Long {
        val startTime = System.nanoTime()
        val sortedList = mergeSort(list)
        val endTime = System.nanoTime()

        if (sortedList.isNotSorted) throw IllegalStateException("Output list is not sorted")

        return (endTime - startTime) / 1000
    }
}