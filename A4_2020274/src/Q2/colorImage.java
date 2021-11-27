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
        System.out.println("Enter the pixels of the image: ");
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
        System.out.println("Enter the pixels of the image: ");
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
        System.out.println("Enter the pixels of the image: ");
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
        System.out.println("Enter the width of the image: ");
        int width = Integer.parseInt(Main.scanner.next());
        System.out.println("Enter the height of the image: ");
        int height = Integer.parseInt(Main.scanner.next());
        colorImage image = new colorImage(width, height);
        System.out.println("Default image is created: ");
        image.showPixels();
        allColorImages.add(image);
    }

    public colorImage grayscale(){
        colorImage grayscale = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int average = (redPixels[i][j] + greenPixels[i][j] + bluePixels[i][j]) / 3;
                grayscale.redPixels[i][j] = average;
                grayscale.greenPixels[i][j] = average;
                grayscale.bluePixels[i][j] = average;
            }
        }
        return grayscale;
    }

    public colorImage invert(){
        colorImage invert = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                invert.redPixels[i][j] = 255 - redPixels[i][j];
                invert.greenPixels[i][j] = 255 - greenPixels[i][j];
                invert.bluePixels[i][j] = 255 - bluePixels[i][j];
            }
        }
        return invert;
    }

    public colorImage mirror(){
        colorImage mirror = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mirror.redPixels[i][j] = redPixels[i][width - j - 1];
                mirror.greenPixels[i][j] = greenPixels[i][width - j - 1];
                mirror.bluePixels[i][j] = bluePixels[i][width - j - 1];
            }
        }
        return mirror;
    }

    public colorImage rotate(){
        colorImage rotate = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotate.redPixels[i][j] = redPixels[height - j - 1][i];
                rotate.greenPixels[i][j] = greenPixels[height - j - 1][i];
                rotate.bluePixels[i][j] = bluePixels[height - j - 1][i];
            }
        }
        return rotate;
    }

    public colorImage crop(){
        colorImage crop = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                crop.redPixels[i][j] = redPixels[i][j];
                crop.greenPixels[i][j] = greenPixels[i][j];
                crop.bluePixels[i][j] = bluePixels[i][j];
            }
        }
        return crop;
    }

    public colorImage scale(int newWidth, int newHeight){
        colorImage scale = new colorImage(newWidth, newHeight);
        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                scale.redPixels[i][j] = redPixels[i][j];
                scale.greenPixels[i][j] = greenPixels[i][j];
                scale.bluePixels[i][j] = bluePixels[i][j];
            }
        }
        return scale;
    }

    public colorImage resize(int newWidth, int newHeight){
        colorImage resize = new colorImage(newWidth, newHeight);
        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                resize.redPixels[i][j] = redPixels[i][j];
                resize.greenPixels[i][j] = greenPixels[i][j];
                resize.bluePixels[i][j] = bluePixels[i][j];
            }
        }
        return resize;
    }

    public colorImage rotate(int angle){
        colorImage rotate = new colorImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotate.redPixels[i][j] = redPixels[i][j];
                rotate.greenPixels[i][j] = greenPixels[i][j];
                rotate.bluePixels[i][j] = bluePixels[i][j];
            }
        }
        return rotate;
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
