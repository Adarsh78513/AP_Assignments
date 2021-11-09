import java.util.ArrayList;

public class AllMatrix {
    static char id = 'a';
    static ArrayList<Matrix> allMatrix = new ArrayList<>();
    static String[] matrixTypes = {"Rectangular Matrix", "Row Matrix", "Column Matrix",
            "Square Matrix", "Symmetric Matrix", "Skew-symmetric Matrix",
            "Upper-triangular Matrix", "Lower-triangular Matrix", "Singular Matrix",
            "Diagonal Matrix", "Scalar Matrix", "Identity Matrix",
            "Singleton Matrix", "Ones Matrix", "Null Matrix"};

    public static char validID(){
        return id++;
    }

    public static void addMatrix(Matrix matrix){
        allMatrix.add(matrix);
    }

    public static Matrix getMatrix(char id){
        for(Matrix matrix : allMatrix){
            if(matrix.getID() == id){
                return matrix;
            }
        }
        System.out.println("There is no matrix with ID " + id);
        return null;
    }

    public static void removeMatrix(char id){
        for(Matrix matrix : allMatrix){
            if(matrix.getID() == id){
                allMatrix.remove(matrix);
                return;
            }
        }
        System.out.println("There was no matrix with ID " + id);
    }

    //print all matrix
    public static void printAllMatrix(){
        for(Matrix matrix : allMatrix){
            System.out.println(matrix);
        }
    }

    public static void printMatrixType(String type) {
        for(Matrix matrix : allMatrix){
            if(matrix.getMatrixType().equals(type)){
                System.out.println(matrix);
            }
        }
    }
}
