package lab5;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRows() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }

    public int calculateDeterminant() {
        if (getRows() != getColumns()) {
            throw new IllegalArgumentException("Matrix must be square to calculate determinant.");
        }
        return calculateDeterminant(matrix);
    }

    private int calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }

        int determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += Math.pow(-1, i) * mat[0][i] * calculateDeterminant(getSubMatrix(mat, 0, i));
        }
        return determinant;
    }

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

