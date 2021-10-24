public class SquareMatrix implements Matrix {
    int column, row;
    int[][] m;

    SquareMatrix(){
        this.column = this.row = 3;
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
        //TODO: reduce to rref and calculate determinant
        return 0;
    }

    @Override
    public Matrix transpose() {
        return null;
    }

    @Override
    public void matrixType() {

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
        System.out.print("Enter the size of the matrix: ");
        int size = Integer.parseInt(Main.scanner.nextLine());
        setRow(size);
        setColumn(size);

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

    private void setRow(int row){
        this.row = row;
    }

    private void setColumn(int column){
        this.column = column;
    }
}
