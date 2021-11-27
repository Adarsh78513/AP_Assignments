package Q2;

interface Image  {

    public void setWidth(int width);
    public void setHeight(int height);
    public int getWidth();
    public int getHeight();
    public void inputPixels();
    public void showPixels();
    public Image negative();
    public void createImage();
    public int getImageNumber();




//    T image;
//    int width;
//    int height;
//
//    public Image(T image, int width, int height) {
//        this.image = image;
//        this.width = width;
//        this.height = height;
//    }
//
//    public T getImage() {
//        return image;
//    }
//
//    public void setImage(T image) {
//        this.image = image;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }

//    public T negative(T image) {
//        if (image instanceof grayscaleImage) {
//            grayscaleImage negImage = ((grayscaleImage) image).negative(((grayscaleImage) image));
//            return (T)negImage;
//        }
//        else if (image instanceof colorImage) {
//            colorImage negImage = ((colorImage) image).negative(((colorImage) image));
//        }
//        else{
//            return null;
//        }
//    }
}
