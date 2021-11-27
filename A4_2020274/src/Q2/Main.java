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
                    Image image = new colorImage();
                    image.inputPixels();
                }
                else if (choice2 == 2) {
                    Image image = new greyScaleImage();
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
                    Image image = new colorImage();
                    image.createImage();
                }
                else if (choice2 == 2) {
                    Image image = new greyScaleImage();
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
                    for ( Image image : colorImage.allColorImages){
                        System.out.println(image.getImageNumber());
                    }
                    int choice3 = scanner.nextInt();
                    for ( Image image : colorImage.allColorImages){
                        if ( image.getImageNumber() == choice3){
                            System.out.println(image);
                        }
                    }
                }
                else if ( choice2 == 2) {
                    System.out.println("Choose the image you want to see from the following: ");
                    for ( Image image : greyScaleImage.allGreyScaleImages){
                        System.out.println(image.getImageNumber());
                    }
                    int choice3 = scanner.nextInt();
                    for ( Image image : greyScaleImage.allGreyScaleImages){
                        if ( image.getImageNumber() == choice3){
                            System.out.println(image);
                        }
                    }
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
