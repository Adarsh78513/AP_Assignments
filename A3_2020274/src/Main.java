import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("***The entries should be space seperated and " +
                "each row should be in different line***");
        System.out.println("Enter the matrix.");

        ArrayList<int[]> matrix = new ArrayList<>();
        int[] r;
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            r = new int[s.length];
            for ( int i = 0; i< s.length; i++ ) {
                r[i] = Integer.parseInt(s[i]);
            }
            matrix.add(r);
        }

        int row = matrix.get(0).length;
        int column = matrix.size();
        int[][] m = new int[column][row];
        for ( int i = 0; i < column; i++){
            m[i] = matrix.get(i);
        }
        System.out.println(Arrays.deepToString(m));

    }
}
