
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var matrixScore = function (matrix) {
    this.rows = matrix.length;
    this.columns = matrix[0].length;
    let sumOfMaxBinaryValueInRows = (1 << (this.columns - 1)) * this.rows;

    for (let column = 1; column < this.columns; ++column) {
        let sameBitsAsInFirstColumn = totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column);
        let maxBitsOfOneInColumn = Math.max(sameBitsAsInFirstColumn, this.rows - sameBitsAsInFirstColumn);
        sumOfMaxBinaryValueInRows += (1 << (this.columns - column - 1)) * maxBitsOfOneInColumn;
    }

    return sumOfMaxBinaryValueInRows;
};

/**
 * @param {number[][]} matrix
 * @param {number} column 
 * @return {number}
 */
function totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column) {
    let totalSameBits = 0;
    for (let row = 0; row < this.rows; ++row) {
        totalSameBits += (matrix[row][column] === matrix[row][0]) ? 1 : 0;
    }
    return totalSameBits;
}
