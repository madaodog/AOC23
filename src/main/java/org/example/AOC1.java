package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AOC1 {
    String session;
    String fileURL;
    String fileLocation;

    public AOC1(String session, String fileURL) {
        this.session = session;
        this.fileURL = fileURL;
        this.fileLocation = "src/main/resources/AOC1.txt";
    }

    public List<Integer> findFirstAndLastDigit() throws Exception {
        StoreFileContent storeFileContent = new StoreFileContent(this.fileURL, this.session, this.fileLocation);
        storeFileContent.store();
        List<Integer> ListOfFirstAndLastDigit = new ArrayList<>();
        Scanner scanner = new Scanner(storeFileContent.file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split("");
            String firstDigit = "";
            String lastDigit = "";
            for (int i = 0; i < line.length(); i++) {
                if (lineArray[i].matches("[0-9]")) {
                    if (firstDigit.equals("")) {
                        firstDigit = lineArray[i];
                    }
                    lastDigit = lineArray[i];
                }
            }
            ListOfFirstAndLastDigit.add(Integer.parseInt(firstDigit) * 10 + Integer.parseInt(lastDigit));
        }
        return ListOfFirstAndLastDigit;
    }

    public int sumOfFirstAndLastDigit() throws Exception {
        List<Integer> ListOfFirstAndLastDigit = findFirstAndLastDigit();
        int sum = 0;
        for (int i = 0; i < ListOfFirstAndLastDigit.size(); i++) {
            sum += ListOfFirstAndLastDigit.get(i);
        }
        return sum;
    }

    public Integer sum() throws Exception {
        List<Integer> ListOfFirstAndLastDigit = findFirstAndLastDigit();
        int sum = 0;
        for (int i = 0; i < ListOfFirstAndLastDigit.size(); i++) {
            sum += ListOfFirstAndLastDigit.get(i);
        }
        return sum;
    }

}


