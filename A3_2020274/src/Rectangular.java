interface Rectangular extends Matrix {
    static void assignMatrixType(int[][] m){
        System.out.println("Rectangular Matrix");
        if (m.length == 1) {
            Matrix matrix = new RowMatrix();
            matrix.setMatrix(m);
        }
        else if ( m[0].length == 1){
            Matrix matrix = new ColumnMatrix();
            matrix.setMatrix(m);
        }
        else{
            Matrix matrix = new RectangularMatrix();
            matrix.setMatrix(m);
        }
    }
}
