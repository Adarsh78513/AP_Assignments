public class LowerTriangularMatrix extends TriangularMatrix{
    int column, row;
    String type;
    int[][] m;

    LowerTriangularMatrix(){
        this.type = "Lower Triangular Matrix";
        this.column = this.row = 3;
        this.m = new int[column][row];
        for(int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                if ( i < j){
                    this.m[i][j] = 0;
                }
                else{
                    this.m[i][j] = (int)(Math.random() * 10);
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
