public class RowMatrix extends RectangularMatrix{
    int column, row;
    double[][] m;
    char ID;
    String type;

    RowMatrix(){
        this.column = 1;
        this.row = 3;
        this.m = new double[column][row];
        this.type = "Row Matrix";
        //default value for the matrix.
        for ( int i = 0; i < column; i++){
            for ( int j = 0; j< row; j++){
                m[i][j] = (i + 1)* (j + 1);
            }
        }

    }
    @Override
    public double determinant(double[][] matrix) {
        return 0;
    }



    @Override
    public void matrixType() {
        System.out.println("Row Matrix");
        super.matrixType();
    }

//    @Override
//    public Matrix divide() {
//        return null;
//    }

//    @Override
//    public Matrix inverse() {
//        return null;
//    }

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
    public double[][] getMatrix() {
        return this.m;
    }


    private void setRow(int row){
        this.row = row;
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
