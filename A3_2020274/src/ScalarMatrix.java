public class ScalarMatrix extends DiagonalMatrix{
    String type;
    int row, column;
    double[][] m;

    ScalarMatrix(){
        this.row = 3;
        this.column = 3;
        this.m = new double[row][column];
        this.type = "Scalar Matrix";
        //default value for matrix
        for ( int i = 0; i < row; i++) {
            for ( int j = 0; j < column; j++) {
                if ( i == j) {
                    m[i][j] = 3;

                }
                else {
                    m[i][j] = 0;
                }
            }
        }
    }

    @Override
    public void matrixType(){
        System.out.println(this.type);
        super.matrixType();
    }

    @Override
    public String getMatrixType() {
        return this.type;
    }

}
