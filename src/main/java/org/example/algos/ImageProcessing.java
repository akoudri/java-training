package org.example.algos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageProcessing {

    private int[][][] image, tImage;
    private int width, height;
    private int originalWidth, originalHeight;

    public ImageProcessing() {
        loadImageFromUrl("https://bellard.org/bpg/lena30.jpg");
    }

    private void loadImageFromUrl(String url) {
        try {
            URL photoUrl = new URL(url);
            BufferedInputStream in = new BufferedInputStream(photoUrl.openStream());
            BufferedImage buff = ImageIO.read(in);
            width = buff.getWidth();
            height = buff.getHeight();
            originalWidth = width;
            originalHeight = height;
            image = new int[height][width][3];
            int px, red, green, blue;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    px = buff.getRGB(j, i);
                    red = (px >> 16) & 0xFF;
                    green = (px >> 8) & 0xFF;
                    blue = px & 0xFF;
                    image[i][j][0] = red;
                    image[i][j][1] = green;
                    image[i][j][2] = blue;
                }
            }
            tImage = image.clone();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveImage(String name) {
        File f = new File("src/main/resources/" + name + ".jpg");
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int px, red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = tImage[i][j][0];
                green = tImage[i][j][1];
                blue = tImage[i][j][2];
                px = (red << 16) | (green << 8) | blue;
                buff.setRGB(j, i, px);
            }
        }
        width = originalWidth;
        height = originalHeight;
        try {
            ImageIO.write(buff, "jpg", f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void flipVertically() {
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    tImage[height - i - 1][j][k] = image[i][j][k];
                }
            }
        }
    }

    public void flipHorizontally() {
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                tImage[i][j] = image[i][width - j - 1];
            }
        }
    }

    public void grayScale() {
        tImage = new int[height][width][3];
        int gray;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                gray = (image[i][j][0] + image[i][j][1] + image[i][j][2]) / 3;
                tImage[i][j][0] = gray;
                tImage[i][j][1] = gray;
                tImage[i][j][2] = gray;
            }
        }
    }

    public void zoomCenter() {
        tImage = new int[height][width][3];
        int ti = 0, tj = 0;
        int val;
        for (int i = height / 4; i < 3 * height / 4; i++) {
            for (int j = width / 4; j < 3 * width / 4; j++) {
                for (int k = 0; k < 3; k++) {
                    val = image[i][j][k];
                    tImage[ti][tj][k] = val;
                    tImage[ti+1][tj][k] = val;
                    tImage[ti][tj+1][k] = val;
                    tImage[ti+1][tj+1][k] = val;
                }
                tj += 2;
            }
            tj = 0;
            ti += 2;
        }
    }

    public void sepia() {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                tImage[i][j][0] = Math.min(255, (int) (0.393 * image[i][j][0] + 0.769 * image[i][j][1] + 0.189 * image[i][j][2]));
                tImage[i][j][1] = Math.min(255, (int) (0.349 * image[i][j][0] + 0.686 * image[i][j][1] + 0.168 * image[i][j][2]));
                tImage[i][j][2] = Math.min(255, (int) (0.272 * image[i][j][0] + 0.534 * image[i][j][1] + 0.131 * image[i][j][2]));
            }
        }
    }

    public void invert() {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                tImage[i][j][0] = 255 - image[i][j][0];
                tImage[i][j][1] = 255 - image[i][j][1];
                tImage[i][j][2] = 255 - image[i][j][2];
            }
        }
    }

    public void swap(int times) {
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    tImage[i][j][k] = image[i][j][(k + times) % 3];
                }
            }
        }
    }

    public void adjustBrightness(int val) {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tImage[i][j][0] = Math.min(255, image[i][j][0] + val);
                tImage[i][j][1] = Math.min(255, image[i][j][1] + val);
                tImage[i][j][2] = Math.min(255, image[i][j][2] + val);
            }
        }
    }

    public void adjustContrast(int factor) {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tImage[i][j][0] = Math.min(255, Math.max(0, (image[i][j][0] - 128) * factor + 128));
                tImage[i][j][1] = Math.min(255, Math.max(0, (image[i][j][1] - 128) * factor + 128));
                tImage[i][j][2] = Math.min(255, Math.max(0, (image[i][j][2] - 128) * factor + 128));
            }
        }
    }

    public void oldStyle(int borderWidth, int offset, int brightness) {
        tImage = new int[height][width][3];
        for (int i = borderWidth; i < height - borderWidth; i += offset) {
            for (int j = borderWidth; j < width - borderWidth; j += offset) {
                if (brightness > 0) {
                    for (int k = 0; k < 3; k++) {
                        tImage[i][j][k] = Math.min(image[i][j][k] + brightness, 255);
                    }
                } else {
                    for (int k = 0; k < 3; k++) {
                        tImage[i][j][k] = Math.max(image[i][j][k] + brightness, 0);
                    }
                }

            }
        }
    }

    public void rightRotate() {
        tImage = new int[width][height][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                for (int k = 0; k < 3; k++) {
                    tImage[j][height - i - 1][k] = image[i][j][k];
                }
            }
        }
    }

    public void leftRotate() {
        tImage = new int[width][height][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                for (int k = 0; k < 3; k++) {
                    tImage[width - j - 1][i][k] = image[i][j][k];
                }
            }
        }
    }

    public void rotate(int angle) {
        tImage = new int[width][height][3];
        double radians = Math.toRadians(angle);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        int centerX = width / 2;
        int centerY = height / 2;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                int x = (int) (cos * (j - centerX) + sin * (i - centerY) + centerX);
                int y = (int) (cos * (i - centerY) - sin * (j - centerX) + centerY);
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    for (int k = 0; k < 3; k++) {
                        tImage[y][x][k] = image[i][j][k];
                    }
                }
            }
        }
    }

    //Simple scale - more complex are required to avoid pixelation
    //like bilinear or bicubic interpolation
    public void scale(double factor) {
        height = (int) (height * factor);
        width= (int) (width * factor);
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    tImage[i][j][k] = image[(int) (i / factor)][(int) (j / factor)][k];
                }
            }
        }
    }

    public void stretchVertically(double factor) {
        height = (int) (height * factor);
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            int y = (int) (i / factor);
            y = Math.min(y, originalHeight - 1); // Ensure we don't exceed original height
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    tImage[i][j][k] = image[y][j][k];
                }
            }
        }
    }

    public void stretchHorizontally(double factor) {
        width = (int) (width * factor);
        tImage = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int x = (int) (j / factor);
                x = Math.min(x, originalWidth - 1); // Ensure we don't exceed original width
                for (int k = 0; k < 3; k++) {
                    tImage[i][j][k] = image[i][x][k];
                }
            }
        }
    }


    public static void main(String[] args) {
        ImageProcessing processing = new ImageProcessing();
        processing.flipVertically();
        processing.saveImage("lenna_verticalflip");
        processing.flipHorizontally();
        processing.saveImage("lenna_horizontalflip");
        processing.zoomCenter();
        processing.saveImage("lenna_zoomcenter");
        processing.grayScale();
        processing.saveImage("lenna_grayscale");
        processing.sepia();
        processing.saveImage("lenna_sepia");
        processing.invert();
        processing.saveImage("lenna_negative");
        processing.swap(1);
        processing.saveImage("lenna_swap1");
        processing.swap(2);
        processing.saveImage("lenna_swap2");
        processing.adjustBrightness(30);
        processing.saveImage("lenna_brightness");
        processing.adjustContrast(2);
        processing.saveImage("lenna_contrast");
        processing.oldStyle(20, 2, 0);
        processing.saveImage("lenna_oldstyle");
        processing.rightRotate();
        processing.saveImage("lenna_rightrotate");
        processing.leftRotate();
        processing.saveImage("lenna_leftrotate");
        processing.scale(2.0);
        processing.saveImage("lenna_scale");
        processing.rotate(45);
        processing.saveImage("lenna_rotateangle");
        processing.stretchVertically(2.0);
        processing.saveImage("lenna_verticalstretch");
        processing.stretchHorizontally(3.0);
        processing.saveImage("lenna_horizontalstretch");
    }

}