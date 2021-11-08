public class DiagonalMatrix extends TriangularMatrix{
    String type;

    DiagonalMatrix(){
        this.type = "Diagonal Matrix";
    }

    @Override
    public void matrixType(){
        System.out.println(this.type);
        super.matrixType();
    }
}
