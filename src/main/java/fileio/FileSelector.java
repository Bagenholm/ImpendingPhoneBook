package fileio;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileSelector {

    public static File chooseJsonFile() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter jsonExtensionFilter = new FileChooser.ExtensionFilter("json-file", "*.json");
        return getFile(fileChooser, jsonExtensionFilter);
    }

    public static File chooseImageFile() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageExtensionFilter = new FileChooser.ExtensionFilter("images", "*.gif", "*.png", "*.jpg" );
        return getFile(fileChooser, imageExtensionFilter);
    }

    private static File getFile(FileChooser fileChooser, FileChooser.ExtensionFilter extensionFilter) {
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setTitle("Choose Location");
        File initDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(initDirectory);
        return fileChooser.showSaveDialog(new Stage());
    }

}
