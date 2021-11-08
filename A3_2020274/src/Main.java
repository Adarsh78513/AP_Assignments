import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //takes input from user for matrix
        int[][] m = takeMatrixInput();
        Matrix.assignMatrixType(m);
        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] takeMatrixInput(){
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for ( int i = 0; i < rows; i++){
            System.out.print("Enter elements for row " + (i+1) + ": ");
            for ( int j = 0; j < columns; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
