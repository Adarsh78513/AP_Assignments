//Square matrix with the value of determinant equal to zero

public class SingularMatrix extends SquareMatrix{

    char ID;
    int column , row;
    String type;
    double[][] m;

    SingularMatrix(){
        this.type = "Singular Matrix";
        this.row = this.column = 3;
        //TODO: Set a proper matrix as default
        this.m = new double[][]{{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
    }

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
    }

    @Override
    public char getID() {
        return this.ID;
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
