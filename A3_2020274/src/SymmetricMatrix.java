public class SymmetricMatrix extends SquareMatrix{
    int column, row;
    double[][] m;
    char ID;
    String type;

    SymmetricMatrix(){
        this.column = 3;
        this.row = 3;
        this.type = "Symmetric Matrix";
        this.m = new double[this.row][this.column];
        for ( int i = 0; i < this.row; i++) {
            for ( int j = 0; j < this.column; j++) {
                this.m[i][j] = i + j;
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
