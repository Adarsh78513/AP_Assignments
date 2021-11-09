public class ColumnMatrix extends RectangularMatrix{
    int column, row;
    int[][] m;
    String type;

    ColumnMatrix(){
        this.column  = 3;
        this.row = 1;
        this.m = new int[column][row];
        this.type = "Column Matrix";
        //default value for the matrix.
        for ( int i = 0; i < column; i++){
            for ( int j = 0; j< row; j++){
                m[i][j] = (i + 1)* (j + 1);
            }
        }
    }

    @Override
    public int determinant() {
        return 0;
    }

    @Override
    public void matrixType() {
        System.out.println("Column Matrix");
        super.matrixType();
    }


//    @Override
//    public Matrix divide() {
//        return null;
//    }

    @Override
    public Matrix inverse() {
        return null;
    }

    @Override
    public int getMean() {
        return 0;
    }

    @Override
    public void setSizes() {
        System.out.print("Enter the size of the column: ");
        int column = Integer.parseInt(Main.scanner.nextLine());
        setColumn(column);
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public int[][] getMatrix() {
        return this.m;
    }

//    @Override
//    public void setMatrix(int[][] matrix){
//        this.m = matrix;
//    }

    private void setColumn(int column){
        this.column = column;
    }

    @Override
    public String getMatrixType() {
        return this.type;
    }
}
