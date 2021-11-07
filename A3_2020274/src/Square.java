interface Square extends Matrix {
    static void assignMatrixType(int[][] m){
        System.out.println("Square matrix");
        boolean symmetric = true;
        boolean skewSymmetric = true;
        boolean TriangularMatrix = true;
        boolean UpperTriangularMatrix = true;
        boolean LowerTriangularMatrix = true;
        boolean DiagonalMatrix = true;
        boolean IdentityMatrix = true;
        boolean ScalarMatrix = true;

        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(m[i][j] != m[j][i]){
                    symmetric = false;
                }
                if(m[i][j] != -m[j][i]){
                    skewSymmetric = false;
                }
                if ( i > j && m[i][j] != 0){
                    UpperTriangularMatrix = false;
                }
                if ( i < j && m[i][j] != 0){
                    LowerTriangularMatrix = false;
                }

            }
        }

        TriangularMatrix = UpperTriangularMatrix || LowerTriangularMatrix;
        DiagonalMatrix = UpperTriangularMatrix && LowerTriangularMatrix;

        //TODO: assign for singular matrix (complete the rref shit)
        if(symmetric){
            System.out.println("Symmetric");
            Matrix matrix = new SymmetricMatrix();
            matrix.setMatrix(m);
        }
        else if(skewSymmetric){
            System.out.println("Skew-symmetric");
            Matrix matrix = new SkewSymmetricMatrix();
            matrix.setMatrix(m);
        }

        else if ( DiagonalMatrix){
            System.out.println("Diagonal Matrix");
            int temp = m[0][0];
            for ( int i = 0; i < m.length; i++){
                if (m[i][i] != temp) {
                    ScalarMatrix = false;
                    break;
                }
            }
            if ( ScalarMatrix){
                if ( temp != 1){
                    IdentityMatrix = false;
                }
            }

            if ( IdentityMatrix){
                System.out.println("Identity Matrix");
                Matrix matrix = new IdentityMatrix();
                matrix.setMatrix(m);
            }
            else if ( ScalarMatrix){
                System.out.println("Scalar Matrix");
                Matrix matrix = new ScalarMatrix();
                matrix.setMatrix(m);
            }
            else{
                System.out.println("Diagonal Matrix");
                Matrix matrix = new DiagonalMatrix();
                matrix.setMatrix(m);
            }
        }

        //Making triangular matrix
        else if ( TriangularMatrix){
            System.out.println("Triangular");
            if(UpperTriangularMatrix){
                System.out.println("Upper Triangular Matrix");
                Matrix matrix = new UpperTriangularMatrix();
                matrix.setMatrix(m);
            }
            else{
                System.out.println("Lower Triangular Matrix");
                Matrix matrix = new LowerTriangularMatrix();
                matrix.setMatrix(m);
            }
        }

    }
}
