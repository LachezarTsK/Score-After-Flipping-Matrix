
public class Solution {

    private int rows;
    private int columns;

    public int matrixScore(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        int sumOfMaxBinaryValueInRows = (1 << (columns - 1)) * rows;

        for (int column = 1; column < columns; ++column) {
            int sameBitsAsInFirstColumn = totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column);
            int maxBitsOfOneInColumn = Math.max(sameBitsAsInFirstColumn, rows - sameBitsAsInFirstColumn);
            sumOfMaxBinaryValueInRows += (1 << (columns - column - 1)) * maxBitsOfOneInColumn;
        }

        return sumOfMaxBinaryValueInRows;
    }

    private int totalSameBitsInCurrentColumnAsInFirstColumn(int[][] matrix, int column) {
        int totalSameBits = 0;
        for (int row = 0; row < rows; ++row) {
            totalSameBits += (matrix[row][column] == matrix[row][0]) ? 1 : 0;
        }
        return totalSameBits;
    }
}
