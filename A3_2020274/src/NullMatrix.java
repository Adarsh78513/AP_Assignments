public class NullMatrix extends RectangularMatrix{
    String type;
    //TODO: set a proper type

    NullMatrix(){
        this.type = "Null Matrix";
    }

    @Override
    public String getMatrixType() {
        return this.type;
    }
}
