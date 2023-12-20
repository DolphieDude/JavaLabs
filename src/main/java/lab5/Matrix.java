package lab5;

/**
 * The Matrix class represents a mathematical matrix and provides operations
 * such as calculating the determinant.
 *
 * @author Andrii Cherevatyi
 */
public class Matrix {

    /**
     * The two-dimensional array representing the matrix.
     */
    private int[][] matrix;

    /**
     * Constructs a Matrix object with the specified matrix data.
     *
     * @param matrix The two-dimensional array representing the matrix.
     */
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Gets the matrix data.
     *
     * @return The two-dimensional array representing the matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Sets the matrix data.
     *
     * @param matrix The two-dimensional array representing the matrix.
     */
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Gets the number of rows in the matrix.
     *
     * @return The number of rows.
     */
    public int getRows() {
        return matrix.length;
    }

    /**
     * Gets the number of columns in the matrix.
     *
     * @return The number of columns.
     */
    public int getColumns() {
        return matrix[0].length;
    }

    /**
     * Calculates the determinant of the matrix.
     *
     * @return The determinant of the matrix.
     * @throws IllegalArgumentException If the matrix is not square.
     */
    public int calculateDeterminant() throws IllegalArgumentException {
        if (getRows() != getColumns()) {
            throw new IllegalArgumentException("Matrix must be square to calculate determinant.");
        }
        return calculateDeterminant(matrix);
    }

    /**
     * Recursively calculates the determinant of a submatrix.
     *
     * @param mat The two-dimensional array representing the submatrix.
     * @return The determinant of the submatrix.
     */
    private int calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }

        int determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += (int) (Math.pow(-1, i) * mat[0][i] * calculateDeterminant(getSubMatrix(mat, 0, i)));
        }
        return determinant;
    }

    /**
     * Creates and returns a submatrix by excluding a specified row and column.
     *
     * @param mat The two-dimensional array representing the original matrix.
     * @param row The index of the row to be excluded.
     * @param col The index of the column to be excluded.
     * @return The submatrix after excluding the specified row and column.
     */
    private int[][] getSubMatrix(int[][] mat, int row, int col) {
        int n = mat.length;
        int[][] subMatrix = new int[n - 1][n - 1];

        int rowIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }

            int colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }

                subMatrix[rowIndex][colIndex] = mat[i][j];
                colIndex++;
            }

            rowIndex++;
        }

        return subMatrix;
    }
}
