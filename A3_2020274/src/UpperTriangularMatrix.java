public class UpperTriangularMatrix extends TriangularMatrix{
    int column,row;
    String type;
    int[][] m;

    UpperTriangularMatrix(){
        this.column = this.row = 3;
        this.type = "Upper-triangular Matrix";
        this.m = new int[column][row];
        //making default upper triangular matrix
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if ( i > j){
                    this.m[i][j] = 0;
                }
                else{
                    this.m[i][j] = (int)(Math.random()*10);
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
