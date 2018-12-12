//package util;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class AsciiReader {
//    boolean negative;
//
//    public ASCII() {
//        this(false);
//    }
//
//    public ASCII(final boolean negative) {
//        this.negative = negative;
//    }
//
//    public String convert(final BufferedImage image) {
//        StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());
//        for (int y = 0; y < image.getHeight(); y++) {
//            if (sb.length() != 0) sb.append("\n");
//            for (int x = 0; x < image.getWidth(); x++) {
//                Color pixelColor = new Color(image.getRGB(x, y));
//                double gValue = (double) pixelColor.getRed() * 0.2989 + (double) pixelColor.getBlue() * 0.5870 + (double) pixelColor.getGreen() * 0.1140;
//                final char s = negative ? returnStrNeg(gValue) : returnStrPos(gValue);
//                sb.append(s);
//            }
//        }
//        return sb.toString();
//    }
//}
