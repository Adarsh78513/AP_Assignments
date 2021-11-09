import java.util.ArrayList;
import java.util.Arrays;

public class SquareMatrix implements Square {
    char ID;
    int column, row;
    double[][] m;
    String type;
    static ArrayList<Matrix> allSquareMatrix = new ArrayList<>();

    SquareMatrix(){
        this.column = this.row = 3;
        this.type = "Square Matrix";

        //default value for the matrix.
        this.m = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }

//    @Override
//    public double determinant() {
//        //TODO: reduce to rref and calculate determinant
//
//
//        return 2;
//    }
    //TODO:Remove this method
    @Override
    public double determinant(double A[][],int N) {
        double det = 0;
        if (N == 1) {
            det = A[0][0];
        } else if (N == 2) {
            det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else {
            det = 0;
            for (int j1 = 0; j1 < N; j1++) {
                double[][] m = new double[N - 1][];
                for (int k = 0; k < (N - 1); k++) {
                    m[k] = new double[N - 1];
                }
                for (int i = 1; i < N; i++) {
                    int j2 = 0;
                    for (int j = 0; j < N; j++) {
                        if (j == j1)
                            continue;
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return det;
    }

    @Override
    public void matrixType() {
        System.out.println(this.type);
    }



//    @Override
//    public double[][] inverse() {
//        if ( this.determinant(this.getMatrix(), this.getMatrix().length) == 0){
//            System.out.println("This matrix does not have a inverse");
//            return null;
//        }
//        else {
//            double[][] temp = rowReduce(this.m);
//            double[][] inverse = new double[column][row];
//            for ( int i = 0; i < column; i++) {
//                for (int j = 0; j < row; j++) {
//                    inverse[i][j] = temp[j][i];
//                }
//            }
//            for ( int i = 0; i < column; i++){
//                System.out.println(Arrays.toString(inverse[i]));
//            }
//            return inverse;
//        }
//    }

    //row reduce a matrix
    public double[][] rowReduce(double[][] matrix){
        double[][] reduced = modifiedMatrix(matrix);
        for ( int i = 0; i < matrix.length - 1; i++){
            reduced = multiply(reduced, i, 1.0 / reduced[i][i]);

            for ( int j = i + 1; j < matrix.length; j++){
                reduced = sum(reduced, i + 1, 1, i, -1 * (reduced[i + 1][i]));
                System.out.println("Row reducing the matrix");
                System.out.println(Arrays.deepToString(reduced));
            }

        }

        return reduced;
    }

    //TODO: Remove these functions too
    @Override
    public double[][] inverse(double[][] a) {
        int n = a.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double[][] a, int[] index){
        int n = index.length;
        double[] c = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    //multiply rows with a number and add them
    public double[][] sum(double[][] matrix, int row1,double mul1,  int row2, double mul2){
        for ( int i = 0; i < column; i++){
            matrix[i][row1] = matrix[i][row1] * mul1 + matrix[i][row2] * mul2;
        }
        return matrix;
    }

    //multiply row with a number
    public double[][] multiply(double[][] matrix, int row, double mul){
        for ( int i = 0; i < column; i++){
            matrix[i][row] = matrix[i][row] * mul;
        }
        return matrix;
    }

    public static double[][] modifiedMatrix(double[][] matrix){
        //Identity matrix added at the end for calculating rref
        double[][] bigMatrix = new double[matrix.length][matrix.length * 2];
        for ( int i = 0; i < matrix.length; i++){
            for ( int j = 0; j < matrix.length; j++){
                bigMatrix[i][j] = matrix[i][j];
            }
        }
        for ( int i = matrix.length; i < bigMatrix[0].length; i++){
            for ( int j = 0; j < matrix.length; j++){
                if ( i - matrix.length == j) {
                    bigMatrix[j][i] = 1;
                }else{
                    bigMatrix[j][i] = 0;
                }
            }
        }

        //printing the matrix
//        for (int[] ints : bigMatrix) {
//            System.out.println(Arrays.toString(ints));
//        }
        return bigMatrix;
    }

    @Override
    public int getMean() {
        return 0;
    }

    @Override
    public void setSizes() {
        System.out.print("Enter the size of the matrix: ");
        int size = Integer.parseInt(Main.scanner.nextLine());
        setRow(size);
        setColumn(size);

    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public double[][] getMatrix() {
        return this.m;
    }

    @Override
    public void setMatrix(double[][] matrix) {
        this.m = matrix;
        this.column = this.row = m.length;
        this.ID = AllMatrix.validID();
        allSquareMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }

    @Override
    public void setMatrix(){
        this.column = this.row = m.length;
        this.ID = AllMatrix.validID();
        allSquareMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }





    @Override
    public String getMatrixType() {
        return this.type;
    }


    private void setRow(int row){
        this.row = row;
    }

    private void setColumn(int column){
        this.column = column;
    }

    @Override
    public char getID() {
        return this.ID;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ").append(this.type).append(" with ID ").append(this.ID).append("\n");
        for (double[] ints : m) {
            for (double anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
