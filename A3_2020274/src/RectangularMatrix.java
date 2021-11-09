import java.util.ArrayList;

public class RectangularMatrix implements Rectangular{
    char ID;
    int column;
    int row;
    double[][] m;
    String type;
    static ArrayList<Matrix> allRectangularMatrix = new ArrayList<>();

    RectangularMatrix(){
        this.column = 3;
        this.row = 2;
        this.type = "Rectangular Matrix";

        //default value for the matrix.
        this.m = new double[][]{{1, 2, 3}, {4, 5, 6}};
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
    public double determinant(double[][] matrix, int n) {
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
    public double[][] inverse(double a[][]) {
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
