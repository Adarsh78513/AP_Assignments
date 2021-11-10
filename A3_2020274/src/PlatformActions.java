import java.util.Objects;
import java.util.Arrays;

public class PlatformActions {
    public static boolean perform(String action){
        if(action.matches(".*[-+*/].*")){
            if ( action.matches(".*[.].*") ){
                String a = action.replaceAll(" ", "");
                char[] actions = a.toCharArray();

                Matrix x = AllMatrix.getMatrix(actions[0]);
                Matrix y = AllMatrix.getMatrix(actions[3]);

                assert x != null;
                assert y != null;

                if ( actions[2] == '*'){
                    Matrix.elementWiseMultiplication(x, y);
                }
                else if ( actions[2] == '/'){
                    Matrix.elementWiseDivision(x, y);
                }
                else if ( actions[2] == '+'){
                    Matrix.add(x, y);
                }
                else if ( actions[2] == '-'){
                    Matrix.subtract(x, y);
                }
                else {
                    System.out.println("Error: Invalid action");
                }
                return true;
            }
            String a = action.replaceAll(" ", "");
            char[] actions = a.toCharArray();

            //for working with operators
            if (actions.length != 3){
                System.out.println(action + "is not a valid operation.");
                return true;
            }
            else if ( actions[1] == '+' ){
                Matrix x = AllMatrix.getMatrix(actions[0]);
                Matrix y = AllMatrix.getMatrix(actions[2]);

                assert x != null;
                assert y != null;
                Matrix.add(x, y);
            }
            else if ( actions[1] == '-'){
                Matrix x = AllMatrix.getMatrix(actions[0]);
                Matrix y = AllMatrix.getMatrix(actions[2]);

                assert x != null;
                assert y != null;
                Matrix.subtract(x, y);
            }
            else if ( actions[1] == '*' ){
                Matrix x = AllMatrix.getMatrix(actions[0]);
                Matrix y = AllMatrix.getMatrix(actions[2]);

                assert x != null;
                assert y != null;
                Matrix.multiply(x, y);
            }
            else if ( actions[1] == '/'){
                Matrix x = AllMatrix.getMatrix(actions[0]);
                Matrix y = AllMatrix.getMatrix(actions[2]);

                assert x != null;
                assert y != null;
                Matrix.divide(x, y);
            }
            else{
                System.out.println("Not a valid instruction.");
                return true;
            }
        }
        else{
            String[] actions = action.split(" ");
            switch (actions[0]) {
                case "Exit":
                case "exit":
                    return false;
                case "enter":
                    //taking matrix input from the user
                    Matrix.takeMatrixInput();
                    break;
//                case "c":
//                    //for when we need to create a new matrix of a type
//                    if (actions.length == 1){
//                    }
//                    break;
                case "show":
                    if ( actions.length == 1){

                        //This was for printing all the matrices types
//                        for ( int i = 0; i < AllMatrix.matrixTypes.length ; i++){
//                            System.out.println(i + ". " + AllMatrix.matrixTypes[i]);
//                        }
                        AllMatrix.printAllMatrixTypes();

                        System.out.print("Choose a matrix type by entering the index from above: ");
                        int index = Integer.parseInt(Main.scanner.nextLine());
                        AllMatrix.printMatrixType(AllMatrix.matrixTypes[index - 1]);
                    }
                    else if (actions[1].equals("A")){
                        AllMatrix.printAllMatrix();
                    }
                    else if ( actions[1].length() == 1){
                        Matrix temp = AllMatrix.getMatrix(actions[1].charAt(0));
                        //TODO: make override the toString functions to print out the matrix
                        System.out.println(temp);
                    }
                    else if (Arrays.asList(AllMatrix.matrixTypes).contains(actions[1])){
                        AllMatrix.printMatrixType(actions[1]);
                    }
                    break;
                case "det":
                    Matrix temp = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert temp != null;
                    double det = temp.determinant(temp.getMatrix());
                    System.out.println("Determinant of the matrix with ID "
                            + actions[1] + " is " + det);
                    break;
                case "inv":
                    Matrix t = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert t != null;
                    double[][] inv = t.inverse(t.getMatrix());
                    System.out.println("Inverse of the matrix " + actions[1] + " is ");
                    for ( int i = 0; i < inv.length; i++){
                        System.out.println(Arrays.toString(inv[i]));
                    }
                    break;
                case "create":
                    AllMatrix.printAllMatrixTypes();
                    System.out.println("For creating a matrix of a certain type...");
                    System.out.print("Choose a matrix type by entering the index from above: ");
                    int index2 = Integer.parseInt(Main.scanner.nextLine());
                    Matrix.createMatrix(index2);
                    break;
                case "tra":
                    Matrix t2 = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert t2 != null;
                    double[][] transpose = Matrix.matrixTranspose(t2);
                    break;
                case "mean":
                    Matrix t3 = AllMatrix.getMatrix(actions[1].charAt(0));
                    char a;
                    if ( actions.length == 2){
                        System.out.println("""
                    Enter r for row wise mean.
                    Enter c for column wise mean.
                    Enter a for mean of all the elements.
                    """);
                        a = Main.scanner.nextLine().charAt(0);
                    }
                    else{
                        a = actions[2].charAt(0);
                    }
                    Matrix.mean(t3, a);
                    //TODO: mean function
                    break;
                case "type":
                    if(actions.length == 1){
                        System.out.println("Not a valid instruction");
                        break;
                    }

                    Matrix t4 = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert t4 != null;
                    t4.matrixType();
                    break;
                case "st":
                    Matrix t5 = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert t5 != null;
                    if ( t5.getRow() != t5.getColumn()){
                        System.out.println("This matrix can not be added with it's transpose.");
                        break;
                    }
                    double[][] m2 = Matrix.matrixTranspose(t5);
                    double[][] m1 = t5.getMatrix();
                    double[][] m = new double[t5.getColumn()][t5.getRow()];
                    for ( int i = 0 ; i < t5.getColumn(); i++ ){
                        for ( int j = 0; j< t5.getRow(); j++){
                            m[i][j] = m1[i][j] + m2[i][j];
                        }
                    }
                    System.out.println("The sum of the matrix and it's transpose is: ");
                    for ( int i = 0; i < t5.getColumn(); i++){
                        System.out.println(Arrays.toString(m[i]));
                    }

                    break;
                case "help":
                    System.out.println("""
                            Commands to work with:
                            1. Take matrices as input and label them with appropriate matrix-types. >> enter
                            2. Create matrices of requested matrix-types and label them with appropriate matrix-types. >> create
                            3. Display all the matrix-type labels of a requested matrix. >> type a
                            \t(here a is the matrix ID)
                            4. Perform addition, subtraction, multiplication & division. >> a + b or a - b or a * b....here a and b are the matrix ID
                            5.\s
                            6. Transpose matrices.>> tra a
                            \t(here a is the matrix ID)
                            7. Inverse matrices.>>inv a
                            \t(here a is the matrix ID)
                            8. Compute means: row-wise mean, column-wise mean, mean of all the elements. >> mean
                            \t\t\t\t\t\t\t\t\t\tmean r (row wise mean)
                            \t\t\t\t\t\t\t\t\t\tmean c (Column wise mean)
                            \t\t\t\t\t\t\t\t\t\tmean a (mean of all the elements)
                            9. Compute determinants. >> det a
                            \t(here a is the matrix ID)
                            10. Compute (A + transpose of A) for a matrix A. >> st a
                            \t(here a is the matrix ID)
                            11. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.>> show


                            //to view a particular matrix>> show a
                            \t(here a is the matrix ID)
                            //to view all matrix>> show A
                            \t(here A is for all and is not a matrix ID.)""");
                    break;
                default:
                    System.out.println("Enter a valid command.");
                    break;
            }
        }



        return true;
    }

}
