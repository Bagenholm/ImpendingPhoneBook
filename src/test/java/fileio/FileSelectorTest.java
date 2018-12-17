package fileio;

import li.flor.nativejfilechooser.NativeJFileChooser;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FileSelectorTest {

    /**
     * Testing through reflection because of private method. Normally not recommended to do this but since we cannot access all the code in the class
     * because of the fileChooser window opening we have to test parts of it instead.
     */

    @Test
    void returnsNullInGetFileForSaveWhenGivingNullAsInputParameter() {


        try {
            JFileChooser jfileChooser = null;
            Method method = new FileSelector().getClass().getDeclaredMethod("getFileForSave", JFileChooser.class);
            method.setAccessible(true);
            assertThrows(Exception.class, () ->  method.invoke("getFileForSave", jfileChooser));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



    }

    @Test
    void throwsExceptionInGetFileForLoadWhenGivingNullAsInputParameter() {


        try {
            JFileChooser jfileChooser = null;
            Method method = new FileSelector().getClass().getDeclaredMethod("getFileFromLoad", JFileChooser.class);
            method.setAccessible(true);
            assertThrows(Exception.class, () ->  method.invoke("getFileFromLoad", jfileChooser));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }



    @Test
    void expectedFileChooserSettingsReturned() {

        Class classArray[] = new Class[]{String.class, String.class};

        Method method = null;
        try {
            method = new FileSelector().getClass().getDeclaredMethod("getFileChooser", classArray);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        method.setAccessible(true);
        try {

            JFileChooser methodJFileChooser = (JFileChooser) method.invoke("getFileChooser","Json files", "json");
            JFileChooser vanillaJFileChooser = new NativeJFileChooser(System.getProperty("user.home"));
            vanillaJFileChooser.setFileFilter(new FileNameExtensionFilter("Json files", "json"));
            assertEquals(methodJFileChooser.getFileFilter().getDescription(), vanillaJFileChooser.getFileFilter().getDescription());
            assertEquals(methodJFileChooser.getCurrentDirectory().getName(), vanillaJFileChooser.getCurrentDirectory().getName());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}