public class ScalarMatrix extends DiagonalMatrix{
    int row, column;
    int[][] m;

    ScalarMatrix(){
        this.row = 3;
        this.column = 3;
        this.m = new int[row][column];

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
}
