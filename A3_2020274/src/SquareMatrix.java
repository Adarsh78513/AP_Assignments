import java.util.ArrayList;

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

    @Override
    public double determinant(double[][] matrix) {
        double det;
        int size = matrix.length;
        if (size == 1) {
            det = matrix[0][0];
        }
        else if (size == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }
        else {
            det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                    matrix[0][1] *(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                    matrix[0][2] *(matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return det;
    }

    @Override
    public double[][] inverse(double[][] a){
        if (this.determinant(this.getMatrix() ) == 0){
            System.out.println("The matrix is not invertible");
            return null;
        }
        if ( this.getRow() == 1){
            return new double[][]{{1.0 / this.getMatrix()[0][0]}};
        }
        else if ( this.getRow() == 2){
            double det = this.determinant(this.getMatrix());
            return new double[][]{{(this.getMatrix()[1][1]) /det, (this.getMatrix()[0][1] * (-1))/det},
                    { (-1 * this.getMatrix()[1][0]) /det, (this.getMatrix()[0][0]) / det}};
        }
        else {
            double det = this.determinant(this.getMatrix());
            double[][] temp = this.getMatrix();
            double[][] m = new double[3][3];
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    m[i][j] = ((temp[(j + 1) % 3][(i + 1) % 3] * temp[(j+ 2) % 3][( i + 2) % 3]) -
                            (temp[( j + 1) %3][( i + 2) %3 ] * temp[( j + 2 ) % 3][( i + 1 ) % 3])) / det;
                }
            }
            return m;
        }
    }

    @Override
    public void matrixType() {
        System.out.println(this.type);
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
