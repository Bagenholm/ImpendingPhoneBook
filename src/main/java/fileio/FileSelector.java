package fileio;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileSelector {

    public static File chooseJsonFileSave() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter jsonExtensionFilter = new FileChooser.ExtensionFilter("json-file", "*.json");
        return getFileForSave(fileChooser, jsonExtensionFilter);
    }

    public static File chooseJsonFileLoad() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter jsonExtensionFilter = new FileChooser.ExtensionFilter("json-file", "*.json");
        return getFileForLoad(fileChooser, jsonExtensionFilter);
    }

    public static File chooseImageFileSave() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageExtensionFilter = new FileChooser.ExtensionFilter("images", "*.gif", "*.png", "*.jpg" );
        return getFileForSave(fileChooser, imageExtensionFilter);
    }

    public static File chooseImageFileLoad() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageExtensionFilter = new FileChooser.ExtensionFilter("images", "*.gif", "*.png", "*.jpg" );
        return getFileForLoad(fileChooser, imageExtensionFilter);
    }

    private static File getFileForSave(FileChooser fileChooser, FileChooser.ExtensionFilter extensionFilter) {
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Choose Location");
        File initDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(initDirectory);

        File file = fileChooser.showSaveDialog(new Stage());
        if (file == null) {
            System.out.println("no file selected");
        }

        return file;

    }

    private static File getFileForLoad(FileChooser fileChooser, FileChooser.ExtensionFilter extensionFilter) {
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Choose Location");
        File initDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(initDirectory);

        File file = fileChooser.showOpenDialog(new Stage());
        if (file == null) {
            System.out.println("no file selected");
        }

        return file;

    }

}
