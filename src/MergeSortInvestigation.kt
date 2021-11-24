import java.util.*
import kotlin.math.abs
import kotlin.random.Random

class MergeSortInvestigation {

    private fun generateList(size: Int): List<Int> {
        return List(size) {
            Random.nextInt()
        }
    }

    fun investigate(testsCount: Int, startSize: Int = 10, stepSize: Int = 10): List<Long> {
        val result = mutableListOf<Long>()

        for (i in 0 until testsCount) {
            val size = startSize + i * stepSize
            val list = generateList(size)

            result.add(testList(list))
        }

        return result
    }

    private fun testList(list: List<Int>): Long {
        val startTime = Date().time
        val sortedList = mergeSort(list)
        val endTime = Date().time

        if (sortedList.isNotSorted) throw IllegalStateException("Output list is not sorted")

        return abs(endTime - startTime)
    }
}