import java.util.Arrays;

interface Matrix {
    static void assignMatrixType(int[][] matrix) {
        if ( matrix.length == matrix[0].length ){
            System.out.println("This is a square matrix...");
            Square.assignMatrixType(matrix);
        }
        else{
            System.out.println("This is not rectangular matrix...");
            Rectangular.assignMatrixType(matrix);
        }
    }

    int determinant();
    static int[][] matrixTranspose(Matrix m){
        int[][] temp = m.getMatrix();
        int[][] transpose = new int[m.getColumn()][m.getRow()];
        for ( int i = 0; i < m.getColumn(); i++){
            for ( int j = 0; j < m.getRow(); j++){
                transpose[i][j] = temp[j][i];
            }
        }
        System.out.println("The transpose of the matrix is: ");
        System.out.println(Arrays.deepToString(transpose));
        return transpose;
    }

    void matrixType();

    static int[][] add(Matrix x, Matrix y){
        if (y.getColumn() == x.getColumn() && y.getRow() == x.getRow()){
            int[][] m1 = x.getMatrix();
            int[][] m2 = y.getMatrix();
            int[][] m = new int[x.getColumn()][x.getRow()];
            for ( int i = 0 ; i < x.getColumn(); i++ ){
                for ( int j = 0; j< x.getRow(); j++){
                    m[i][j] = m1[i][j] + m2[i][j];
                }
            }
            System.out.println("The matrix after adding is: ");
            for ( int i = 0; i < x.getColumn(); i++){
                System.out.println(Arrays.toString(m[i]));
            }
            return m;
        }
        //returning null if the matrix can not be added(not of same size)
        System.out.println("These matrices can not be added together.");
        return null;
    }
    static int[][] subtract(Matrix x, Matrix y){
        //subtract the matrix y from the matrix x
        if (y.getColumn() == x.getColumn() && y.getRow() == x.getRow()){
            int[][] m1 = x.getMatrix();
            int[][] m2 = y.getMatrix();
            int[][] m = new int[x.getColumn()][x.getRow()];
            for ( int i = 0 ; i < x.getColumn(); i++ ){
                for ( int j = 0; j< x.getRow(); j++){
                    m[i][j] = m1[i][j] - m2[i][j];
                }
            }
            System.out.println("The matrix after subtracting is: ");
            for ( int i = 0; i < x.getColumn(); i++){
                System.out.println(Arrays.toString(m[i]));
            }

            return m;

        }
        //returning null if the matrices can not be subtracted
        System.out.println("These matrices can not be subtracted together.");
        return null;
    }
    static int[][] multiply(Matrix x, Matrix y){
        if (y.getColumn() == x.getRow() && y.getRow() == x.getColumn()){
            int temp = 0;
            int[][] m1 = x.getMatrix();
            int[][] m2 = y.getMatrix();
            int[][] m = new int[x.getColumn()][y.getRow()];
            //TODO: multiplication of two matrices

            //printing the result
            System.out.println("The matrix after multiplying is: ");
            for ( int i = 0; i < x.getColumn(); i++){
                System.out.println(Arrays.toString(m[i]));
            }
            return m;

        }
        System.out.println("These matrices can not be added together.");
        return null;
    }

    static void divide(Matrix x, Matrix y){
        return;
    }

    public static int[][] takeMatrixInput(){
        System.out.print("Enter number of rows: ");
        int rows = Main.scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = Main.scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for ( int i = 0; i < rows; i++){
            System.out.print("Enter elements for row " + (i+1) + ": ");
            for ( int j = 0; j < columns; j++){
                matrix[i][j] = Main.scanner.nextInt();
            }
        }
        Matrix.assignMatrixType(matrix);
        return matrix;
    }

    Matrix inverse();
    int getMean();
    void setSizes();
    int getRow();
    int getColumn();
    int[][] getMatrix();
    void setMatrix(int[][] matrix);
    String getMatrixType();
    char getID();
}
