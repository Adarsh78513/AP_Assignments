public class SkewSymmetricMatrix extends SquareMatrix{
    int column, row;
    String type;
    double[][] m;

    SkewSymmetricMatrix(){
        type = "Skew-symmetric Matrix";
        this.column = 3;
        this.row = 3;

        double[][] m = new double[column][row];

        for ( int i= 0 ; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                m[i][j] = i-j;
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
