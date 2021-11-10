interface Singular {
    static void assignMatrixType(double[][] m){
        if ( m[0][0] == 0){
            System.out.println("Null matrix");
            Matrix matrix = new NullMatrix();
            matrix.setMatrix(m);
        }
        else if ( m[0][0] == 1){
            System.out.println("Ones matrix");
            Matrix matrix = new OnesMatrix();
            matrix.setMatrix(m);
        }
        else{
            System.out.println("General Singleton matrix");
            Matrix matrix = new SingletonMatrix();
            matrix.setMatrix(m);
        }
    }
}
