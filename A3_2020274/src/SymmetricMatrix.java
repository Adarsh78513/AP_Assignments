public class SymmetricMatrix extends SquareMatrix{
    int column;
    int row;
    int[][] m;
    String type;

    SymmetricMatrix(){
        this.column = 3;
        this.row = 3;
        this.type = "Symmetric Matrix";
        this.m = new int[this.row][this.column];
        for ( int i = 0; i < this.row; i++) {
            for ( int j = 0; j < this.column; j++) {
                this.m[i][j] = i + j;
            }
        }
    }

}
