public class SingletonMatrix extends SquareMatrix{
    String type;

    SingletonMatrix(){
        this.type = "Singleton Matrix";
    }
    @Override
    public String getMatrixType() {
        return this.type;
    }
}
