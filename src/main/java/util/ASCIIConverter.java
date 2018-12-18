package util;

import fileio.FileSelector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ASCIIConverter {

    public BufferedImage makeImage() {
        try {
            BufferedImage image = ImageIO.read(FileSelector.chooseImageFileLoad());
            return image;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @param image
     * @return image as String, ascii art.
     */
    public String convert(BufferedImage image) {
        if (image == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());
        for (int y = 0; y < image.getHeight(); y = y+4) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            for (int x = 0; x < image.getWidth(); x = x + 2) {
                Color pixelColor = new Color(image.getRGB(x, y));
                double gValue = (double) pixelColor.getRed() * 0.2989
                        + (double) pixelColor.getBlue() * 0.5870
                        + (double) pixelColor.getGreen() * 0.1140;
                char s = returnStrPos(gValue);
                sb.append(s);
            }
        }
        return sb.toString() + " \n \n \n";
    }

    /**
     * @param g grayscale value
     * @return char matching "dark value".
     */

    private char returnStrPos(double g)
    {
        char str;

        if (g >= 230.0) {
            str = ' ';
        } else if (g >= 200.0) {
            str = '.';
        } else if (g >= 180.0) {
            str = '*';
        } else if (g >= 160.0) {
            str = ':';
        } else if (g >= 130.0) {
            str = 'o';
        } else if (g >= 100.0) {
            str = '&';
        } else if (g >= 70.0) {
            str = '8';
        } else if (g >= 50.0) {
            str = '#';
        } else {
            str = '@';
        }
        return str;
    }
}
