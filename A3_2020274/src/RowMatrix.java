public class RowMatrix extends RectangularMatrix{
    int column, row;
    int[][] m;

    RowMatrix(){
        this.column = 1;
        this.row = 3;
        this.m = new int[column][row];

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
    public Matrix divide() {
        return null;
    }

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
        System.out.print("Enter the size of the row: ");
        int row = Integer.parseInt(Main.scanner.nextLine());
        setRow(row);
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

    private void setRow(int row){
        this.row = row;
    }
}
