import java.util.ArrayList;

public class RectangularMatrix implements Rectangular{
    char ID;
    int column, row;
    double[][] m;
    String type;
    static ArrayList<Matrix> allRectangularMatrix = new ArrayList<>();

    RectangularMatrix(){
        this.column = 2;
        this.row = 3;
        this.type = "Rectangular Matrix";

        this.m = new double[column][row];

        //default value for the matrix.
        for ( int i = 0; i < column; i++){
            for ( int j = 0; j< row; j++){
                m[i][j] = (i + 1)* (j + 1);
            }
        }
    }

    @Override
    public void setMatrix(double[][] m){
        this.m = m;
        this.column = m.length;
        this.row = m[0].length;
        this.ID = AllMatrix.validID();
        allRectangularMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }

    @Override
    public double determinant() {
        System.out.println("Invalid request.");
        return -1;
    }


    @Override
    public void matrixType() {
        System.out.println(this.type);
    }

//    @Override
//    public Matrix divide() {
//        return null;
//    }

    @Override
    public double[][] inverse() {
        System.out.println("Inverse of a Rectangular matrix does not exist.");
        return null;
    }

    @Override
    public int getMean() {
        return 0;
    }

    @Override
    public void setSizes() {
        System.out.print("Enter the number of rows: ");
        int row = Integer.parseInt(Main.scanner.nextLine());
        System.out.print("Enter the number of columns: ");
        int column = Integer.parseInt(Main.scanner.nextLine());
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

    @Override
    public String getMatrixType() {
        return this.type;
    }

    @Override
    public char getID() {
        return this.ID;
    }


    private void setRow(int row){
        this.row = row;
    }
    private void setColumn(int column){
        this.column = column;
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
