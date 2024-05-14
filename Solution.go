
package main

import (
	"fmt"
	"math"
)

var rows = 0
var columns = 0

func matrixScore(matrix [][]int) int {
	rows = len(matrix)
	columns = len(matrix[0])
	var sumOfMaxBinaryValueInRows = (1 << (columns - 1)) * rows

	for column := 1; column < columns; column++ {
		var sameBitsAsInFirstColumn = totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column)
		var maxBitsOfOneInColumn = int(math.Max(float64(sameBitsAsInFirstColumn), float64(rows-sameBitsAsInFirstColumn)))
		sumOfMaxBinaryValueInRows += (1 << (columns - column - 1)) * maxBitsOfOneInColumn
	}

	return sumOfMaxBinaryValueInRows
}

func totalSameBitsInCurrentColumnAsInFirstColumn(matrix [][]int, column int) int {
	var totalSameBits = 0
	for row := 0; row < rows; row++ {
		if matrix[row][column] == matrix[row][0] {
			totalSameBits++
		}
	}
	return totalSameBits
}
