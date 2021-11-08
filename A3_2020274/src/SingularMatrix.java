//Square matrix with the value of determinant equal to zero

public class SingularMatrix {

    int column , row;
    String type;
    int[][] m;

    SingularMatrix(){
        this.type = "Singular Matrix";
        this.row = this.column = 3;
        //TODO: Set a proper matrix as default
        this.m = new int[column][row];
    }
}
