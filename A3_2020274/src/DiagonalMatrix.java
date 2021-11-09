public class DiagonalMatrix extends TriangularMatrix{
    char ID;
    int column, row;
    int[][] m;
    String type;

    DiagonalMatrix(){
        this.column = this.row = 3;
        this.m = new int[column][row];
        this.type = "Diagonal Matrix";
        for (int i = 0; i < this.m.length; i++) {
            m[i][i] = 1 + i;
        }
    }

    @Override
    public void matrixType(){
        System.out.println(this.type);
        super.matrixType();
    }
    @Override
    public int determinant() {
        int temp = 1;
        for (int i = 0; i < this.m.length; i++) {
            temp *= this.m[i][i];
        }
        return temp;
    }

    @Override
    public String getMatrixType() {
        return this.type;
    }
}
