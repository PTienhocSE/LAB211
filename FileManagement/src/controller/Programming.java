package controller;

import java.io.File;

public class Programming {

    Validation valid = new Validation();

    public void checkInputPath() {
        System.out.print("Please input Path: ");
        String path = valid.checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("----- Result Analysis -----");
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
            System.out.println("Folders: " + getForder(path));
        } else {
            System.err.println("Path isn't file.");
        }
    }

    private String getPath(String path) {
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(0, toNameFile);
    }

    private String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    private String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot + 1, path.length());
    }

    private String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon);
    }

    private String getForder(String path) {
        int positionColon = path.indexOf("\\");
        int positionDot = path.lastIndexOf("\\");
        path = path.substring(positionColon+1, positionDot);
        return "[" + path + "]";
    }

}
