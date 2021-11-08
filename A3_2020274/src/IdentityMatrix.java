public class IdentityMatrix extends ScalarMatrix{
    int row, column;
    int[][] m;
    String type;

    IdentityMatrix(){
        this.row = 3;
        this.column = 3;
        this.m = new int[row][column];
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
    public void matrixType(){
        System.out.println(this.type);
        super.matrixType();
    }
}
