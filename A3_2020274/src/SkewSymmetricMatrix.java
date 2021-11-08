public class SkewSymmetricMatrix extends SquareMatrix{
    int column, row;
    String type;

    SkewSymmetricMatrix(){
        type = "Skew Symmetric matrix";
        this.column = 3;
        this.row = 3;

        int[][] matrix = new int[column][row];

        for ( int i= 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = i-j;
            }
        }
    }

    @Override
    public void matrixType(){
        System.out.println(this.type);
        super.matrixType();
    }
}
