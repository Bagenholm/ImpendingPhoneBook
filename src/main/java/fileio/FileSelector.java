package fileio;

import li.flor.nativejfilechooser.NativeJFileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileSelector {


    /**
     * @return File from one of the chosen extension filters, opens save dialog in subsequent step.
     */
    public static File chooseJsonFileSave() {

        JFileChooser fileChooser = new NativeJFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));
        return getFileForSave(fileChooser);
    }

    /**
     * @return File from one of the chosen extension filters, opens load dialog in subsequent step.
     */

    public static File chooseJsonFileLoad() {

        JFileChooser fileChooser = new NativeJFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));
        return getFileForLoad(fileChooser);
    }


    /**
     * @param fileChooser which is configured with correct extension filter as input.
     * @return file if selected and null if nothing is selected or if error occurred.
     * uses save dialog. Made public to enable testing
     */
    public static File getFileForSave(JFileChooser fileChooser) {

        if (fileChooser==null) {
            System.out.println("no fileChooser as input parameter");
            return null;
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
    public static File getFileForLoad(JFileChooser fileChooser){

            if (fileChooser==null) {
                System.out.println("no fileChooser as input parameter");
                return null;
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


          /* public static File chooseImageFileSave() {

        //todo: om patrik vill använda
        return null;
    }

    public static File chooseImageFileLoad() {

        //todo: om patrik vill använda
        return null;
    }*/


}


