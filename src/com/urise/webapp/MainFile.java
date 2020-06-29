package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) throws IOException {

//        String filePath = ".\\.gitignore";
//        File file = new File(filePath);
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }

        File dir = new File(".\\src\\com\\urise\\webapp");

        MainFile mainFile = new MainFile();
//        File[] list = dir.listFiles();
//        for (File name: list){
//            if (name.isFile()) name.delete();
//
//    }
        mainFile.printDirectoryDeeply(dir);


//        try(FileInputStream fis = new FileInputStream(filePath)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//
//        }


    }
// TODO: make pretty output with reflection, bigger index for catalogs
    public void printDirectoryDeeply(File dir) {

        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {

                if (file.isFile()) System.out.println("File: " + file);

                else if (file.isDirectory()) {
                    System.out.println("Directory: " + file);
                    printDirectoryDeeply(file);
                }

            }
        }


    }


}
