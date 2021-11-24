fun <T : Comparable<T>> mergeSort(list: List<T>): List<T> {
    if (list.size <= 1) return list

    val middle = list.size / 2
    val leftList = list.subList(0, middle)
    val rightList = list.subList(middle, list.size)

    return merge(mergeSort(leftList), mergeSort(rightList))
}

private fun <T : Comparable<T>> merge(leftList: List<T>, rightList: List<T>): MutableList<T> {
    var indexLeft = 0
    var indexRight = 0
    val newList = mutableListOf<T>()

    while (indexLeft < leftList.size && indexRight < rightList.size) {
        if (leftList[indexLeft] <= rightList[indexRight]) {
            newList.add(leftList[indexLeft])
            indexLeft++
        } else {
            newList.add(rightList[indexRight])
            indexRight++
        }
    }

    while (indexLeft < leftList.size) {
        newList.add(leftList[indexLeft])
        indexLeft++
    }

    while (indexRight < rightList.size) {
        newList.add(rightList[indexRight])
        indexRight++
    }

    return newList
}

val <T : Comparable<T>> List<T>.isSorted: Boolean
    get() {
        if (size <= 1) return true

        for (i in 1 until size) {
            if (get(i) < get(i - 1)) {
                return false
            }
        }

        return true
    }

val <T : Comparable<T>> List<T>.isNotSorted: Boolean
    get() = !isSorted