package org.example;

import java.io.File;
import java.io.FileWriter;

public class StoreFileContent {
    FetchFileContent fetchFileContent;
    String fileLocation;
    File file;

    public StoreFileContent(String fileURL, String sessionCookie, String fileLocation) {
        this.fetchFileContent = new FetchFileContent(fileURL, sessionCookie);
        this.fileLocation = fileLocation;
        this.file = new File(this.fileLocation);
    }

    public void store() {
        try {
            String fileContent = this.fetchFileContent.read();
            FileWriter fileWriter = new FileWriter(this.file);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
