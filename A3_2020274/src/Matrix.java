import java.util.Arrays;

interface Matrix {
    static void assignMatrixType(double[][] matrix) {
        //identify a Singular matrix
        boolean SingularMatrix = true;
        double temp = matrix[0][0];
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                if (aDouble != temp) {
                    SingularMatrix = false;
                    break;
                }
            }
        }
        if (SingularMatrix) {
            System.out.println("The matrix is a singular matrix.");
            Singular.assignMatrixType(matrix);
        }
        else if ( matrix.length == matrix[0].length ){
            System.out.println("This is a square matrix...");
            Square.assignMatrixType(matrix);
        }
        else{
            System.out.println("This is not rectangular matrix...");
            Rectangular.assignMatrixType(matrix);
        }
    }

    static void elementWiseMultiplication(Matrix x, Matrix y) {
        double[][] m1 = x.getMatrix();
        double[][] m2 = y.getMatrix();
        double[][] m = new double[x.getRow()][y.getColumn()];
        for (int i = 0; i < x.getRow(); i++) {
            for (int j = 0; j < x.getColumn(); j++) {
                m[i][j] = m1[i][j] * m2[i][j];
            }
        }

        System.out.println("The element wise multiplication of the two matrices is: ");
        for (int i = 0; i < x.getRow(); i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    static void elementWiseDivision(Matrix x, Matrix y) {
        double[][] m1 = x.getMatrix();
        double[][] m2 = y.getMatrix();
        double[][] m = new double[x.getRow()][x.getColumn()];
        for (int i = 0; i < x.getRow(); i++) {
            for (int j = 0; j < x.getColumn(); j++) {
                m[i][j] = m1[i][j] / m2[i][j];
            }
        }

        System.out.println("The element wise division of the two matrices is: ");
        for (int i = 0; i < x.getRow(); i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    double determinant(double[][] matrix);

    static double[][] matrixTranspose(Matrix m){
        double[][] temp = m.getMatrix();
        double[][] transpose = new double[m.getColumn()][m.getRow()];
        for ( int i = 0; i < m.getColumn(); i++){
            for ( int j = 0; j < m.getRow(); j++){
                transpose[i][j] = temp[j][i];
            }
        }
        System.out.println("The transpose of the matrix is: ");
        for ( int i = 0; i < m.getColumn(); i++){
            System.out.println(Arrays.toString(transpose[i]));
        }
        return transpose;
    }

    public static void mean(Matrix m, char p){
        int temp;
        if ( p == 'r'){
            for ( int i = 0; i< m.getRow(); i++){
                double sum = 0;
                for ( int j = 0; j < m.getColumn(); j++){
                    sum += m.getMatrix()[i][j];
                }
                temp = i + 1;
                sum = sum / m.getColumn();
                System.out.println("Mean of row " + temp +  " is " + sum + ".");
            }
        }
        else if ( p == 'c'){
            for ( int i = 0; i< m.getColumn(); i++){
                double sum = 0;
                for ( int j = 0; j < m.getRow(); j++){
                    sum += m.getMatrix()[j][i];

                }
                temp = i + 1;
                sum = sum / m.getRow();
                System.out.println("Mean of column " + temp +  " is " + sum + ".");
            }
        }
        else if ( p == 'a'){
            double sum = 0;
            for ( int i = 0; i< m.getColumn(); i++){
                for ( int j = 0; j < m.getRow(); j++){
                    sum += m.getMatrix()[j][i];
                }
            }
            sum = sum / (m.getColumn() * m.getRow());
            System.out.println("Mean of the matrix is " + sum + ".");
        }
        else{
            System.out.println("Invalid input.");
        }

    }

    void matrixType();

    static double[][] add(Matrix x, Matrix y){
        if ( x.getRow() != y.getRow() || x.getColumn() != y.getColumn() ){
            System.out.println("These matrices can not be added.");
            return null;
        }
        double[][] m1 = x.getMatrix();
        double[][] m2 = y.getMatrix();
        double[][] m = new double[x.getRow()][x.getColumn()];
        for (int i = 0; i < x.getRow(); i++) {
            for (int j = 0; j < x.getColumn(); j++) {
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("Sum of the matrix " + x.getID() + " and " + y.getID() + " is:");
        for (int i = 0; i < x.getRow(); i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }
    static double[][] subtract(Matrix x, Matrix y){
        if ( x.getRow() != y.getRow() || x.getColumn() != y.getColumn() ){
            System.out.println("These matrices can not be subtracted.");
            return null;
        }
        double[][] m1 = x.getMatrix();
        double[][] m2 = y.getMatrix();
        double[][] m = new double[x.getRow()][x.getColumn()];
        for (int i = 0; i < x.getRow(); i++) {
            for (int j = 0; j < x.getColumn(); j++) {
                m[i][j] = m1[i][j] - m2[i][j];
            }
        }

        System.out.println("Difference of the matrix " + x.getID() + " and " + y.getID() + " is:");
        for (int i = 0; i < x.getRow(); i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }
    static double[][] multiply(Matrix x, Matrix y){
        if ( x.getColumn() != y.getRow() ){
            System.out.println("These matrices can not be multiplied.");
            return null;
        }
        double[][] m1 = x.getMatrix();
        double[][] m2 = y.getMatrix();
        double[][] m = new double[x.getRow()][y.getColumn()];
        for (int i = 0; i < x.getRow(); i++) {
            for (int j = 0; j < y.getColumn(); j++) {
                for (int k = 0; k < x.getColumn(); k++) {
                    m[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println("Product of the matrix " + x.getID() + " and " + y.getID() + " is:");
        for (int i = 0; i < x.getRow(); i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }

    static double[][] multiply(double[][] m1, double[][] m2){
        if ( m1.length != m2[0].length || m1[0].length != m2.length ){
            System.out.println("These matrices can not be multiplied.");
            return null;
        }
        double[][] m = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    m[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        System.out.println("Product of the matrix is:");
        for (int i = 0; i < m1.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        return m;
    }

    void divide(Matrix x, Matrix y);


    public static double[][] takeMatrixInput(){
        System.out.print("Enter number of rows: ");
        int rows = Main.scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = Main.scanner.nextInt();
        double[][] matrix = new double[rows][columns];
        for ( int i = 0; i < rows; i++){
            System.out.print("Enter elements for row " + (i+1) + ": ");
            for ( int j = 0; j < columns; j++){
                matrix[i][j] = Main.scanner.nextInt();
            }
        }
        Matrix.assignMatrixType(matrix);
        return matrix;
    }

    static void createMatrix(int matrixType){
        Matrix matrix;
        switch (matrixType) {
            case 1 -> {
                matrix = new RectangularMatrix();
                matrix.setMatrix();
            }
            case 2 -> {
                matrix = new RowMatrix();
                matrix.setMatrix();
            }
            case 3 -> {
                matrix = new ColumnMatrix();
                matrix.setMatrix();
            }
            case 4 -> {
                matrix = new SquareMatrix();
                matrix.setMatrix();
            }
            case 5 -> {
                matrix = new SymmetricMatrix();
                matrix.setMatrix();
            }
            case 6 -> {
                matrix = new SkewSymmetricMatrix();
                matrix.setMatrix();
            }
            case 7 -> {
                matrix = new UpperTriangularMatrix();
                matrix.setMatrix();
            }
            case 8 -> {
                matrix = new LowerTriangularMatrix();
                matrix.setMatrix();
            }
            case 9 -> {
                matrix = new SingularMatrix();
                matrix.setMatrix();
            }
            case 10 -> {
                matrix = new DiagonalMatrix();
                matrix.setMatrix();
            }
            case 11 -> {
                matrix = new ScalarMatrix();
                matrix.setMatrix();
            }
            case 12 -> {
                matrix = new IdentityMatrix();
                matrix.setMatrix();
            }
            case 13 -> {
                matrix = new SingletonMatrix();
                matrix.setMatrix();
            }
            case 14 -> {
                matrix = new OnesMatrix();
                matrix.setMatrix();
            }
            case 15 -> {
                matrix = new NullMatrix();
                matrix.setMatrix();
            }
            default -> System.out.println("Invalid input.");
        }
    }

    public void setMatrix();
    double[][] inverse(double[][] a);
    int getMean();
    void setSizes();
    int getRow();
    int getColumn();
    double[][] getMatrix();
    void setMatrix(double[][] matrix);
    String getMatrixType();
    char getID();
}
