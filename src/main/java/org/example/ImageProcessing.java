package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageProcessing {

    private int[][][] image, tImage;
    private int width, height;

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
            image = new int[height][width][3];
            int px, red, green, blue;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    px = buff.getRGB(j, i);
                    red = (px >> 16) & 0xFF;
                    green = (px >> 8) & 0xFF;
                    blue = px & 0xFF;
                    image[j][i][0] = red;
                    image[j][i][1] = green;
                    image[j][i][2] = blue;
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
                red = tImage[j][i][0];
                green = tImage[j][i][1];
                blue = tImage[j][i][2];
                px = (red << 16) | (green << 8) | blue;
                buff.setRGB(j, i, px);
            }
        }
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
                red = (int) (0.393 * image[i][j][0] + 0.769 * image[i][j][1] + 0.189 * image[i][j][2]);
                green = (int) (0.349 * image[i][j][0] + 0.686 * image[i][j][1] + 0.168 * image[i][j][2]);
                blue = (int) (0.272 * image[i][j][0] + 0.534 * image[i][j][1] + 0.131 * image[i][j][2]);
                tImage[i][j][0] = Math.min(255, red);
                tImage[i][j][1] = Math.min(255, green);
                tImage[i][j][2] = Math.min(255, blue);
            }
        }
    }

    public void invert() {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                red = 255 - image[i][j][0];
                green = 255 - image[i][j][1];
                blue = 255 - image[i][j][2];
                tImage[i][j][0] = red;
                tImage[i][j][1] = green;
                tImage[i][j][2] = blue;
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
                red = Math.min(255, image[i][j][0] + val);
                green = Math.min(255, image[i][j][1] + val);
                blue = Math.min(255, image[i][j][2] + val);
                tImage[i][j][0] = red;
                tImage[i][j][1] = green;
                tImage[i][j][2] = blue;
            }
        }
    }

    public void adjustContrast(int factor) {
        tImage = new int[height][width][3];
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = Math.min(255, Math.max(0, (image[i][j][0] - 128) * factor + 128));
                green = Math.min(255, Math.max(0, (image[i][j][1] - 128) * factor + 128));
                blue = Math.min(255, Math.max(0, (image[i][j][2] - 128) * factor + 128));
                tImage[i][j][0] = red;
                tImage[i][j][1] = green;
                tImage[i][j][2] = blue;
            }
        }
    }

    public void oldStyle() {
        tImage = new int[height][width][3];
        for (int i = 10; i < height - 10; i++) {
            for (int j = 10; j < width - 10; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i%4 == 1 || j%2 == 4) tImage[i][j][k] = 0;
                    else tImage[i][j][k] = Math.max(image[i][j][k] - 50, 0);
                }
            }
        }
    }

    public void leftRotate() {
        tImage = new int[width][height][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                for (int k = 0; k < 3; k++) {
                    tImage[j][height - i - 1][k] = image[i][j][k];
                }
            }
        }
    }

    public void rightRotate() {
        tImage = new int[width][height][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                for (int k = 0; k < 3; k++) {
                    tImage[width - j - 1][i][k] = image[i][j][k];
                }
            }
        }
    }

    public static void main(String[] args) {
        ImageProcessing processing = new ImageProcessing();
        // processing.flipVertically();
        // processing.flipHorizontally();
        // processing.zoomCenter();
        // processing.grayScale();
        // processing.sepia();
        // processing.invert();
        // processing.swap(2);
        // processing.adjustBrightness(30);
        // processing.adjustContrast(2);
        // processing.oldStyle();
        // processing.rightRotate();
        processing.leftRotate();
        processing.saveImage("lenna");
    }

}
