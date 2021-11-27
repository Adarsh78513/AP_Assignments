package Q2;

import java.util.ArrayList;

public class greyScaleImage implements Image{

    int imageNumber;
    private int width;
    private int height;
    private int[][] pixels;
    public static ArrayList<Image> allGreyScaleImages = new ArrayList<>();


    greyScaleImage(int width, int height) {
        this.imageNumber = allGreyScaleImages.size() + colorImage.allColorImages.size() + 1;
        this.width = width;
        this.height = height;
        pixels = new int[height][width];
    }

    greyScaleImage(){
        this.width = 0;
        this.height = 0;
        pixels = new int[height][width];
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

    public int getHeight() {
        return height;
    }

    @Override
    public Image scale(int w, int h) {
        return null;
    }

    @Override
    public Image rotate(int angle) {
        return null;
    }


    public void inputPixels() {
        System.out.println("It has a height of " + height + " and a width of " + width);
        System.out.println("Enter the pixels of the image: ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = Integer.parseInt(Main.scanner.next());
                if ( pixels[i][j] < 0 || pixels[i][j] > 255 ) {
                    System.out.println("Invalid pixel value. " +
                            "Please enter a value between 0 and 255 only.");
                    return;
                }
            }
        }
        allGreyScaleImages.add(this);

    }

    public void showPixels() {
        System.out.println("Showing the Image ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Image negative() {
        greyScaleImage negative = new greyScaleImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negative.pixels[i][j] = 255 - pixels[i][j];
            }
        }
        return negative;
    }

    @Override
    public void createImage() {
        System.out.println("Enter the width of the image: ");
        width = Integer.parseInt(Main.scanner.next());
        System.out.println("Enter the height of the image: ");
        height = Integer.parseInt(Main.scanner.next());
        greyScaleImage image = new greyScaleImage(width, height);
        image.showPixels();
        allGreyScaleImages.add(image);
    }

    public greyScaleImage negative(greyScaleImage image){
        greyScaleImage negative = new greyScaleImage(image.width, image.height);
        for (int i = 0; i < image.height; i++) {
            for (int j = 0; j < image.width; j++) {
                negative.pixels[i][j] = 255 - image.pixels[i][j];
            }
        }
        return negative;
    }

    public greyScaleImage grayscale(greyScaleImage image){
        greyScaleImage grayscale = new greyScaleImage(image.width, image.height);
        for (int i = 0; i < image.height; i++) {
            for (int j = 0; j < image.width; j++) {
                grayscale.pixels[i][j] = (image.pixels[i][j] + image.pixels[i][j] + image.pixels[i][j]) / 3;
            }
        }
        return grayscale;
    }

    public greyScaleImage resize(greyScaleImage image, int newWidth, int newHeight){
        greyScaleImage resized = new greyScaleImage(newWidth, newHeight);
        double xRatio = (double)image.width / newWidth;
        double yRatio = (double)image.height / newHeight;
        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                int x = (int)(j * xRatio);
                int y = (int)(i * yRatio);
                resized.pixels[i][j] = image.pixels[y][x];
            }
        }
        return resized;
    }

    public greyScaleImage crop(greyScaleImage image, int x, int y, int width, int height){
        greyScaleImage cropped = new greyScaleImage(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cropped.pixels[i][j] = image.pixels[i + y][j + x];
            }
        }
        return cropped;
    }

    public greyScaleImage flip(greyScaleImage image) {
        greyScaleImage flipped = new greyScaleImage(image.width, image.height);
        for (int i = 0; i < image.height; i++) {
            for (int j = 0; j < image.width; j++) {
                flipped.pixels[i][j] = image.pixels[image.height - i - 1][j];
            }
        }
        return flipped;
    }

    public greyScaleImage rotate(greyScaleImage image) {
        greyScaleImage rotated = new greyScaleImage(image.width, image.height);
        for (int i = 0; i < image.height; i++) {
            for (int j = 0; j < image.width; j++) {
                rotated.pixels[i][j] = image.pixels[j][image.width - i - 1];
            }
        }
        return rotated;
    }


}
