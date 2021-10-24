import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] list = inputMatrix();
        System.out.println(Arrays.deepToString(list));
    }

    public static int[][] inputMatrix(){

        ArrayList<int[]> matrix = new ArrayList<>();
        int[][] m;
        System.out.println("Enter first row: ");
        String s = scanner.nextLine();
        int length = s.split(" ").length;
        int[] temp;
        while (!s.equals("")){
            temp = new int[length];
            for ( int i = 0; i < length; i++){
                temp[i] = Integer.parseInt(s.split(" ")[i]);
            }
            matrix.add(temp);
            System.out.println("Enter next row(Leave blank to stop): ");
            s = scanner.nextLine();
            if (length != s.split(" ").length){
                System.out.println("Process terminated because of incorrect entry in a row for matrix");
                return new int[0][0];
            }
        }
         m = new int[matrix.size()][matrix.get(0).length];
        int i = 0;
        for ( int[] a : matrix){
            m[i] = a;
            i++;
        }
        return m;
    }

}
