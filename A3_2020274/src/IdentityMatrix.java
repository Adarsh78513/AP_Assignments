public class IdentityMatrix extends ScalarMatrix{
    int row, column;
    double[][] m;
    String type;

    IdentityMatrix(){
        this.row = 3;
        this.column = 3;
        this.m = new double[row][column];
        this.type = "Identity Matrix";

        //default value for matrix
        for ( int i = 0; i < row; i++) {
            for ( int j = 0; j < column; j++) {
                if ( i == j) {
                    m[i][j] = 1;

                }
                else {
                    m[i][j] = 0;
                }
            }
        }
    }

    @Override
    public double determinant() {
        //TODO: reduce to rref and calculate determinant
        return 1;
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
