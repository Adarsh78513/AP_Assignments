import java.util.ArrayList;
import java.util.Arrays;

public class SquareMatrix implements Square {
    char ID;
    int column, row;
    int[][] m;
    String type;
    static ArrayList<Matrix> allSquareMatrix = new ArrayList<>();

    SquareMatrix(){
        this.column = this.row = 3;
        this.m = new int[column][row];
        this.type = "Square Matrix";

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
        return 2;
    }

    @Override
    public void matrixType() {
        System.out.println(this.type);
    }



    @Override
    public int[][] inverse() {
        if ( this.determinant() == 0){
            System.out.println("This matrix does not have a inverse");
            return null;
        }
        else {
            int[][] temp = rowReduce(this.m);
            int[][] inverse = new int[column][row];
            for ( int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    inverse[i][j] = temp[j][i];
                }
            }
            return inverse;
        }
    }

    //row reduce a matrix
    public int[][] rowReduce(int[][] matrix){
        int[][] reduced = modifiedMatrix(matrix);
        reduced = multiply(reduced, 0, reduced[0][0]);
        for ( int i = 0; i < matrix.length; i++){
            sum(reduced, i, 1, i, -1);
        }

        return reduced;
    }

    //multiply rows with a number and add them
    public int[][] sum(int[][] matrix, int row1,int mul1,  int row2, int mul2){
        for ( int i = 0; i < column; i++){
            matrix[i][row1] = matrix[i][row1] * mul1 - matrix[i][row2] * mul2;
        }
        return matrix;
    }

    //multiply row with a number
    public int[][] multiply(int[][] matrix, int row, double mul){
        for ( int i = 0; i < column; i++){
            matrix[i][row] = matrix[i][row] * mul;
        }
        return matrix;
    }

    public static int[][] modifiedMatrix(int[][] matrix){
        //Identity matrix added at the end for calculating rref
        int[][] bigMatrix = new int[matrix.length][matrix.length * 2];
        for ( int i = 0; i < matrix.length; i++){
            for ( int j = 0; j < matrix.length; j++){
                bigMatrix[i][j] = matrix[i][j];
            }
        }
        for ( int i = matrix.length; i < bigMatrix[0].length; i++){
            for ( int j = 0; j < matrix.length; j++){
                if ( i - matrix.length == j) {
                    bigMatrix[j][i] = 1;
                }else{
                    bigMatrix[j][i] = 0;
                }
            }
        }

        //printing the matrix
//        for (int[] ints : bigMatrix) {
//            System.out.println(Arrays.toString(ints));
//        }
        return bigMatrix;
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

    @Override
    public void setMatrix(int[][] matrix) {
        this.m = matrix;
        this.column = this.row = m.length;
        this.ID = AllMatrix.validID();
        allSquareMatrix.add(this);
        AllMatrix.addMatrix(this);
        System.out.println("The ID set for ths matrix is: " + this.ID);
    }



    @Override
    public String getMatrixType() {
        return this.type;
    }


    private void setRow(int row){
        this.row = row;
    }

    private void setColumn(int column){
        this.column = column;
    }

    @Override
    public char getID() {
        return this.ID;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ").append(this.type).append(" with ID ").append(this.ID).append("\n");
        for (int[] ints : m) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
