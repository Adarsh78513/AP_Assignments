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



    public void inputPixels() {
        System.out.println("It has a height of " + height + " and a width of " + width);
        System.out.print("Enter the pixels of the image: ");
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
        System.out.print("Enter the width of the image: ");
        width = Integer.parseInt(Main.scanner.next());
        System.out.print("Enter the height of the image: ");
        height = Integer.parseInt(Main.scanner.next());
        greyScaleImage image = new greyScaleImage(width, height);
        image.showPixels();
        allGreyScaleImages.add(image);
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
                sb.append(pixels[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
