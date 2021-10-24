interface Matrix {
    int determinant();
    Matrix transpose();
    void matrixType();
    static Matrix add(Matrix x, Matrix y){
        if (y.getColumn() == x.getColumn() && y.getRow() == x.getRow()){
            int[][] m1 = x.getMatrix();
            int[][] m2 = y.getMatrix();
            int[][] m = new int[x.getColumn()][x.getRow()];
            for ( int i = 0 ; i < x.getColumn(); i++ ){
                for ( int j = 0; j< x.getRow(); j++){
                    m[i][j] = m1[i][j] + m2[i][j];
                }
            }
            //TODO: make a matrix from m[][]

        }
        System.out.println("These matrices can not be added together.");
        return null;
    }
    static Matrix subtract(Matrix x, Matrix y){
        if (y.getColumn() == x.getColumn() && y.getRow() == x.getRow()){
            int[][] m1 = x.getMatrix();
            int[][] m2 = y.getMatrix();
            int[][] m = new int[x.getColumn()][x.getRow()];
            for ( int i = 0 ; i < x.getColumn(); i++ ){
                for ( int j = 0; j< x.getRow(); j++){
                    m[i][j] = m1[i][j] - m2[i][j];
                }
            }
            //TODO: make a matrix from m[][]

        }
        System.out.println("These matrices can not be added together.");
        return null;
    }
    static Matrix multiply(Matrix x, Matrix y){
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
            //TODO: make a matrix from m[][]

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
}
