package Q2;

import java.util.ArrayList;

public class colorImage implements Image {
    int imageNumber;
    private int width;
    private int height;
    private int[][] redPixels;
    private int[][] greenPixels;
    private int[][] bluePixels;
    public static ArrayList<colorImage> allColorImages = new ArrayList<colorImage>();


    colorImage(int width, int height) {
        this.imageNumber = allColorImages.size() + greyScaleImage.allGreyScaleImages.size() + 1;
        this.width = width;
        this.height = height;
        redPixels = new int[width][height];
        greenPixels = new int[width][height];
        bluePixels = new int[width][height];
    }

    colorImage(){
        this.imageNumber = allColorImages.size() + greyScaleImage.allGreyScaleImages.size() + 1;
        this.width = 0;
        this.height = 0;
        redPixels = new int[width][height];
        greenPixels = new int[width][height];
        bluePixels = new int[width][height];
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void inputPixels(){
        System.out.println("""
                What pixels do you want to enter?
                1. Red
                2. Green
                3. Blue
                4. Stop""");
        int choice = Integer.parseInt(Main.scanner.next());
        boolean stop = false;
        while ( !stop ) {
            switch (choice) {
                case 1 -> inputRedPixels();
                case 2 -> inputGreenPixels();
                case 3 -> inputBluePixels();
                case 4 -> stop = true;
            }
        }
        allColorImages.add(this);

    }


    public void inputRedPixels(){
        System.out.println("It has a height of " + height + " and a width of " + width);
        System.out.print("Enter the pixels of the image: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                redPixels[i][j] = Integer.parseInt(Main.scanner.next());
                if ( redPixels[i][j] < 0 || redPixels[i][j] > 255 ) {
                    System.out.println("Invalid pixel value. " +
                            "Please enter a value between 0 and 255.");
                }
            }
        }
    }

    public void inputGreenPixels(){
        System.out.println("It has a height of " + height + " and a width of " + width);
        System.out.print("Enter the pixels of the image: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                greenPixels[i][j] = Integer.parseInt(Main.scanner.next());
                if ( greenPixels[i][j] < 0 || greenPixels[i][j] > 255 ) {
                    System.out.println("Invalid pixel value. " +
                            "Please enter a value between 0 and 255.");
                }
            }
        }
    }

    public void inputBluePixels(){
        System.out.println("It has a height of " + height + " and a width of " + width);
        System.out.print("Enter the pixels of the image: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bluePixels[i][j] = Integer.parseInt(Main.scanner.next());
                if ( bluePixels[i][j] < 0 || bluePixels[i][j] > 255 ) {
                    System.out.println("Invalid pixel value. " +
                            "Please enter a value between 0 and 255.");
                }
            }
        }
    }


    @Override
    public void showPixels(){
        System.out.println("Here are the pixels of the image: ");
        System.out.println("Red: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(redPixels[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Green: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(greenPixels[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Blue: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(bluePixels[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Override
    public colorImage negative(){
        colorImage negative = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negative.redPixels[i][j] = 255 - redPixels[i][j];
                negative.greenPixels[i][j] = 255 - greenPixels[i][j];
                negative.bluePixels[i][j] = 255 - bluePixels[i][j];
            }
        }
        return negative;
    }

    @Override
    public void createImage() {
        System.out.print("Enter the width of the image: ");
        int width = Integer.parseInt(Main.scanner.next());
        System.out.print("Enter the height of the image: ");
        int height = Integer.parseInt(Main.scanner.next());
        colorImage image = new colorImage(width, height);
        System.out.println("Default image is created: ");
        image.showPixels();
        allColorImages.add(image);
    }

    @Override
    public int getImageNumber() {
        return this.imageNumber;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append("[");
                sb.append(redPixels[i][j]);
                sb.append(" ");
                sb.append(greenPixels[i][j]);
                sb.append(" ");
                sb.append(bluePixels[i][j]);
                sb.append("] ");

            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
