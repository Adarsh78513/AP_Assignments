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

    //TODO: define in the inherited classes
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
            System.out.println(Arrays.deepToString(m));
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
            System.out.println(Arrays.deepToString(m));

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
            for ( int i = 0 ; i < x.getColumn(); i++ ){
                for ( int j = 0; j< y.getRow(); j++){

                    //calculating number for each place in the matrix that we need to return
                    for ( int q = 0; q < x.getColumn(); q ++){
                        for  (int w = 0; w < y.getRow(); w++){
                            temp += m1[q][w] * m2[q][w];
                        }
                    }

                    m[i][j] = temp;
                    temp = 0;

                }
            }
            System.out.println("The matrix after multiplying is: ");
            System.out.println(Arrays.deepToString(m));
            return m;

        }
        System.out.println("These matrices can not be added together.");
        return null;
    }

    Matrix divide();
    Matrix inverse();
    int getMean();
    void setSizes();
    int getRow();
    int getColumn();
    int[][] getMatrix();
    void setMatrix(int[][] matrix);
    String getMatrixType();
}
