package Q1;

public class Rakes {
    static int numberOfLSlots = 5;
    static int numberOfRakes = 2;
    Book[][] b = new Book[numberOfRakes][numberOfLSlots];

    Rakes(){

    }

    public void printRakes(){
        //TODO: if name is same print the IFSC code
        for (int i = 0; i < numberOfRakes; i++){
            System.out.println("Rake number: " + (i+1));
            for (int j = 0; j < numberOfLSlots; j++){
                System.out.print(b[i][j].getBookTitle() + " ");
            }
        }
    }

}
