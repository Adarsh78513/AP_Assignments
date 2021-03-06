import java.util.Arrays;

public class TriangularMatrix extends SquareMatrix {
    char ID;

    @Override
    public void matrixType(){
        super.matrixType();
    }


    @Override
    public double determinant(double[][] matrix) {
        int temp = 1;
        for (int i = 0; i < this.m.length; i++) {
            temp *= this.m[i][i];
        }
        return temp;
    }

    @Override
    public double[][] getMatrix() {
        return this.m;
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
    public String getMatrixType() {
        return this.type;
    }


    @Override
    public void setMatrix(double[][] matrix) {
        this.m = matrix;
        this.column = this.row = m.length;
        this.ID = AllMatrix.validID();
        allSquareMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }

    @Override
    public void setMatrix(){
        this.column = this.row = m.length;
        this.ID = AllMatrix.validID();
        allSquareMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
        //print matrix created
        for (double[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ").append(this.type).append(" with ID ").append(this.ID).append("\n");
        for (double[] ints : m) {
            for (double anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
