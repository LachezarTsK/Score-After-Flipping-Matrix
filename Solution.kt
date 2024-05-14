
import kotlin.math.max

class Solution {

    private var rows = 0
    private var columns = 0

    fun matrixScore(matrix: Array<IntArray>): Int {
        rows = matrix.size
        columns = matrix[0].size
        var sumOfMaxBinaryValueInRows = (1 shl (columns - 1)) * rows

        for (column in 1..<columns) {
            var sameBitsAsInFirstColumn = totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column)
            var maxBitsOfOneInColumn = max(sameBitsAsInFirstColumn, rows - sameBitsAsInFirstColumn)
            sumOfMaxBinaryValueInRows += (1 shl (columns - column - 1)) * maxBitsOfOneInColumn
        }

        return sumOfMaxBinaryValueInRows
    }

    private fun totalSameBitsInCurrentColumnAsInFirstColumn(matrix: Array<IntArray>, column: Int): Int {
        var totalSameBits = 0
        for (row in 0..<rows) {
            totalSameBits += if (matrix[row][column] == matrix[row][0]) 1 else 0
        }
        return totalSameBits
    }
}
