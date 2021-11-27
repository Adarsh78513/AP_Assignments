package Q2;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello World! form Q2");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Printing the menu...");
            System.out.println("""
                    1. Input image
                    2. Create image
                    3. Show image
                    4. Exit""");
            System.out.println("Enter a number form the menu: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Choose from the following: ");
                System.out.println("""
                        1. Colour Image
                        2. Grey Scale Image""");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.print("Enter the width of the image");
                    int width = scanner.nextInt();
                    System.out.print("Enter the height of the image");
                    int height = scanner.nextInt();

                    Image image = new colorImage(width, height);
                    image.inputPixels();
                }
                else if (choice2 == 2) {
                    System.out.print("Enter the width of the image");
                    int width = scanner.nextInt();
                    System.out.print("Enter the height of the image");
                    int height = scanner.nextInt();

                    Image image = new greyScaleImage(width, height);
                    image.inputPixels();
                }
            }
            else if (choice == 2) {
                System.out.println("Choose from the following: ");
                System.out.println("""
                        1. Colour Image
                        2. Grey Scale Image""");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.print("Enter the width of the image");
                    int width = scanner.nextInt();
                    System.out.print("Enter the height of the image");
                    int height = scanner.nextInt();

                    Image image = new colorImage(width, height);
                    image.createImage();
                }
                else if (choice2 == 2) {
                    System.out.print("Enter the width of the image");
                    int width = scanner.nextInt();
                    System.out.print("Enter the height of the image");
                    int height = scanner.nextInt();

                    Image image = new greyScaleImage(width, height);
                    image.createImage();
                }
            }
            else if (choice == 3) {
                System.out.println("Choose from the following: ");
                System.out.println("""
                        1. Colour Image
                        2. Grey Scale Image""");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.println("Choose the image you want to see from the following: ");
                    //TODO: display all the images
//                    for ( Image image : greyScaleImage.allGreyScaleImages){
//                        System.out.println(image.getName());
//                    }
                }
                else if ( choice2 == 2) {
                    System.out.println("Choose the image you want to see from the following: ");

                }
                else {
                    System.out.println("Invalid choice");
                }
            }
            else if (choice == 4) {
                isRunning = false;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
}
