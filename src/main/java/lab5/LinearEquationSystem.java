package lab5;

public class LinearEquationSystem {
    private Matrix coefficientMatrix;
    private int[] freeTerms;

    public LinearEquationSystem(Matrix coefficientMatrix, int[] freeTerms) {
        if (coefficientMatrix.getRows() != freeTerms.length) {
            throw new IllegalArgumentException("Invalid input: Number of equations must match the size of free terms array.");
        }

        this.coefficientMatrix = coefficientMatrix;
        this.freeTerms = freeTerms;
    }

    public Matrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    public int[] getFreeTerms() {
        return freeTerms;
    }

    public void setCoefficientMatrix(Matrix coefficientMatrix) {
        this.coefficientMatrix = coefficientMatrix;
    }

    public void setFreeTerms(int[] freeTerms) {
        if (coefficientMatrix.getRows() != freeTerms.length) {
            throw new IllegalArgumentException("Invalid input: Number of equations must match the size of free terms array.");
        }

        this.freeTerms = freeTerms;
    }

    public double[] solve() {
        int det = coefficientMatrix.calculateDeterminant();
        if (det == 0) {
            throw new ArithmeticException("The system may have no solution or infinitely many solutions.");
        }

        int n = coefficientMatrix.getRows();
        double[] solution = new double[n];

        for (int i = 0; i < n; i++) {
            Matrix modifiedMatrix = modifyMatrix(coefficientMatrix, freeTerms, i);
            double detModified = modifiedMatrix.calculateDeterminant();
            solution[i] = detModified / det;
        }

        return solution;
    }

    private Matrix modifyMatrix(Matrix matrix, int[] values, int columnIndex) {
        int n = matrix.getRows();
        int[][] modifiedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                modifiedMatrix[i][j] = (j == columnIndex) ? values[i] : matrix.getMatrix()[i][j];
            }
        }

        return new Matrix(modifiedMatrix);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int n = coefficientMatrix.getRows();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    result.append(coefficientMatrix.getMatrix()[i][j]).append("x");
                } else if (j == 1) {
                    result.append(" + ").append(coefficientMatrix.getMatrix()[i][j]).append("y");
                } else {
                    result.append(" + ").append(coefficientMatrix.getMatrix()[i][j]).append("z");
                }
            }
            result.append(" = ").append(freeTerms[i]).append("\n");
        }

        return result.toString();
    }
}

