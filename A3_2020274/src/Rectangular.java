interface Rectangular extends Matrix {
    static void assignMatrixType(double[][] m){
        System.out.println("Rectangular Matrix");
        if (m.length == 1) {
            System.out.println("This is a row matrix");
            Matrix matrix = new RowMatrix();
            matrix.setMatrix(m);
        }
        else if ( m[0].length == 1){
            System.out.println("This is a column matrix");
            Matrix matrix = new ColumnMatrix();
            matrix.setMatrix(m);
        }
        else{
            System.out.println("This is a rectangular matrix( not row or column matrix)");
            Matrix matrix = new RectangularMatrix();
            matrix.setMatrix(m);
        }
    }
}
