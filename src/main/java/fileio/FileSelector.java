package fileio;

import li.flor.nativejfilechooser.NativeJFileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileSelector {

    public static File chooseJsonFileSave() {

        JFileChooser fileChooser = new NativeJFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));
        return getFileForSave(fileChooser);
    }

    public static File chooseJsonFileLoad() {

        JFileChooser fileChooser = new NativeJFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));
        return getFileForLoad(fileChooser);
    }

    public static File chooseImageFileSave() {

        //todo: om patrik vill använda
        return null;
    }

    public static File chooseImageFileLoad() {

        //todo: om patrik vill använda
        return null;
    }

    private static File getFileForSave(JFileChooser fileChooser) {

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

    private static File getFileForLoad(JFileChooser fileChooser){

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                return file;

            } else {
                System.out.println("no file selected");
                return null;

            }

        }


}


