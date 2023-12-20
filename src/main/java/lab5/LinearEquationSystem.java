package lab5;

/**
 * The LinearEquationSystem class represents a system of linear algebraic equations.
 * It includes a coefficient matrix and a column vector of free terms, along with
 * methods for solving the system and obtaining a string representation.
 *
 * @author Andrii Cherevatyi
 */
public class LinearEquationSystem {

    /**
     * The coefficient matrix of the system.
     */
    private Matrix coefficientMatrix;

    /**
     * The column vector of free terms in the equations.
     */
    private int[] freeTerms;

    /**
     * Constructs a LinearEquationSystem object with the specified coefficient matrix
     * and column vector of free terms.
     *
     * @param coefficientMatrix The coefficient matrix of the system.
     * @param freeTerms         The column vector of free terms.
     * @throws IllegalArgumentException If the number of equations does not match the size of the free terms array.
     */
    public LinearEquationSystem(Matrix coefficientMatrix, int[] freeTerms) throws IllegalArgumentException {
        if (coefficientMatrix.getRows() != freeTerms.length) {
            throw new IllegalArgumentException("Invalid input: Number of equations must match the size of free terms array.");
        }

        this.coefficientMatrix = coefficientMatrix;
        this.freeTerms = freeTerms;
    }

    /**
     * Gets the coefficient matrix of the system.
     *
     * @return The coefficient matrix.
     */
    public Matrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    /**
     * Gets the column vector of free terms.
     *
     * @return The column vector of free terms.
     */
    public int[] getFreeTerms() {
        return freeTerms;
    }

    /**
     * Sets the coefficient matrix of the system.
     *
     * @param coefficientMatrix The new coefficient matrix.
     */
    public void setCoefficientMatrix(Matrix coefficientMatrix) {
        this.coefficientMatrix = coefficientMatrix;
    }

    /**
     * Sets the column vector of free terms.
     *
     * @param freeTerms The new column vector of free terms.
     * @throws IllegalArgumentException If the number of equations does not match the size of the new free terms array.
     */
    public void setFreeTerms(int[] freeTerms) throws IllegalArgumentException {
        if (coefficientMatrix.getRows() != freeTerms.length) {
            throw new IllegalArgumentException("Invalid input: Number of equations must match the size of free terms array.");
        }

        this.freeTerms = freeTerms;
    }

    /**
     * Solves the system of linear equations.
     *
     * @return An array containing the solution to the system.
     * @throws ArithmeticException If the system may have no solution or infinitely many solutions.
     */
    public double[] solve() throws ArithmeticException {
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

    /**
     * Creates and returns a modified matrix by replacing a column with a new set of values.
     *
     * @param matrix       The original matrix.
     * @param values       The new values to replace the specified column.
     * @param columnIndex  The index of the column to be replaced.
     * @return The modified matrix.
     */
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

    /**
     * Returns a string representation of the LinearEquationSystem.
     *
     * @return A string containing the equations of the system.
     */
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
