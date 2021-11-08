import java.util.Objects;

public class PlatformActions {
    public static boolean perform(String action){
        if(action.matches(".*[-+*/].*")){
            String a = action.replaceAll(" ", "");
            char[] actions = a.toCharArray();

            //for working with operators
            if (actions.length != 3){
                System.out.println(action + "is not a valid operation.");
                return true;
            }
            else if ( actions[1] == '+' ){
                //TODO: get matrix from the ID in the add sub functions itself
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
                case "emat":
                    //taking matrix input from the user
                    Matrix.takeMatrixInput();
                    break;
                case "c":
                    //for when we need to create a new matrix of a type
                    if (actions.length == 1){
                        //TODO:Use hash map to mark each matrix and then make one as the user asks for it
                    }
                    break;
                case "show":
                    if (actions[1].equals("-A")){
                        AllMatrix.printAllMatrix();
                    }
                    else{
                        Matrix temp = AllMatrix.getMatrix(actions[1].charAt(0));
                        //TODO: make override the toString functions to print out the matrix
                        System.out.println(temp);
                    }
                    break;
                case "det ":
                    Matrix temp = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert temp != null;
                    int det = temp.determinant();
                    System.out.println("Determinant of the matrix with ID "
                            + actions[1] + " is " + det);
                    break;
                case "inv":
                    Matrix t = AllMatrix.getMatrix(actions[1].charAt(0));
                    assert t != null;
                    Matrix inv = t.inverse();
                    System.out.println("Inverse of the matrix " + actions[1] + " is " + inv);
                    break;
                default:
                    System.out.println("Enter a valid command.");
                    break;
            }
        }



        return false;
    }

}
