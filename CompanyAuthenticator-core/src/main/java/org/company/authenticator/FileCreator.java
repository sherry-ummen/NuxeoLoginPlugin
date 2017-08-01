package org.company.authenticator;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static void Create(String fileName){
        try {
            String filePath = String.format("c:\\mydrive\\%s.txt",fileName);
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println(String.format("///////////////   File %s is created! ////////////////////////", filePath));
            } else {
                System.out.println(String.format("///////////////   File %s already exists! ////////////////////////", filePath));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
