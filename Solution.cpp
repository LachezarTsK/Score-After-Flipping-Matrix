
#include <span>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    int rows{};
    int columns{};

 public:
    int matrixScore(const vector<vector<int>>& matrix)  {
        rows = matrix.size();
        columns = matrix[0].size();
        int sumOfMaxBinaryValueInRows = (1 << (columns - 1)) * rows;

        for (int column = 1; column < columns; ++column) {
            int sameBitsAsInFirstColumn = totalSameBitsInCurrentColumnAsInFirstColumn(matrix, column);
            int maxBitsOfOneInColumn = max(sameBitsAsInFirstColumn, rows - sameBitsAsInFirstColumn);
            sumOfMaxBinaryValueInRows += (1 << (columns - column - 1)) * maxBitsOfOneInColumn;
        }

        return sumOfMaxBinaryValueInRows;
    }

private:
    int totalSameBitsInCurrentColumnAsInFirstColumn(span<const vector<int>> matrix, int column) const {
        int totalSameBits = 0;
        for (int row = 0; row < rows; ++row) {
            totalSameBits += (matrix[row][column] == matrix[row][0]) ? 1 : 0;
        }
        return totalSameBits;
    }
};
