package util;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader {
    public static String loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "gif", "png"));
        while (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File f = fileChooser.getSelectedFile();
                final BufferedImage image = ImageIO.read(f);
                if (image == null) throw new IllegalArgumentException(f + " is not a valid image.");
                final String ascii = new ASCIIConverter().convert(image);
                return ascii;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "No image.";
    }
}
