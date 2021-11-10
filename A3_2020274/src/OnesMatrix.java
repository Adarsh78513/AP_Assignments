public class OnesMatrix extends RectangularMatrix{
    int column, row;
    char ID;
    String type;
    double[][] m;
    //TODO: set a proper type

    OnesMatrix(){
        this.type = "Ones Matrix";
        m = new double[][]{{1,1,1},{1,1,1},{1,1,1}};
    }
    @Override
    public String getMatrixType() {
        return this.type;
    }

    @Override
    public void setMatrix(double[][] matrix) {
        this.m = matrix;
        this.row = m.length;
        this.column = m[0].length;
        this.ID = AllMatrix.validID();
        allRectangularMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }

    @Override
    public void setMatrix(){
        this.row = m.length;
        this.column = m[0].length;
        this.ID = AllMatrix.validID();
        allRectangularMatrix.add(this);
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
