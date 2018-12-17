package fileio;

import li.flor.nativejfilechooser.NativeJFileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileSelector {

    /**
     * @param fileType sets what description of the file you want in the FileChooser extension filter
     * @param extension sets what file extension you want to have in the extensionFilter
     * @return set fileChooser. Also sets directory to home directory.
     */

    private static JFileChooser getFileChooser(String fileType, String extension) {
        JFileChooser fileChooser = new NativeJFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileNameExtensionFilter(fileType, extension));
        return fileChooser;
    }

    /**
     * @return File from one of the chosen extension filters, opens save dialog in subsequent step.
     */
    public static File chooseJsonFileSave() {

        JFileChooser fileChooser = getFileChooser("Json files", "json");
        return getFileForSave(fileChooser);
    }


    /**
     * @return File from one of the chosen extension filters, opens load dialog in subsequent step.
     */

    public static File chooseJsonFileLoad() {

        JFileChooser fileChooser = getFileChooser("Json files", "json");
        return getFileFromLoad(fileChooser);
    }


    /**
     * @param fileChooser which is configured with correct extension filter as input.
     * @return file if selected and null if nothing is selected or if error occurred.
     * uses save dialog. Made public to enable testing
     */
    private static File getFileForSave(JFileChooser fileChooser) {

        if (fileChooser==null) {

            throw new IllegalArgumentException("no fileChooser as input parameter");
        }

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file;

        }
        else {
            System.out.println("no filename input or cancel pressed");
            return null;

        }

    }

    /**
     * @param fileChooser which is configured with correct extension filter as input.
     * @return file if selected and null if nothing is selected or if error occurred.
     * uses open dialog. Made public to enable testing
     */
    private static File getFileFromLoad(JFileChooser fileChooser){

            if (fileChooser==null) {
                throw new IllegalArgumentException("no fileChooser as input parameter");
            }

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                return file;

            } else {
                System.out.println("no file selected");
                return null;

            }

        }

    //todo: om patrik vill använda
    public static File chooseImageFileSave() {

        JFileChooser fileChooser = getFileChooser("Image-Files", "jpg, png, gif");
        return getFileForSave(fileChooser);

}
    //todo: om patrik vill använda
    public static File chooseImageFileLoad() {


        JFileChooser fileChooser = getFileChooser("Image-Files", "jpg, png, gif");
        return getFileFromLoad(fileChooser);


    }


}


