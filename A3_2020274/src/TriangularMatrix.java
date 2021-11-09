public class TriangularMatrix extends SquareMatrix {


    @Override
    public void matrixType(){
        super.matrixType();
    }

    //TODO: check if this works for all the lower classes
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
