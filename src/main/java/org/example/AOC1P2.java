package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AOC1P2 {
    String session;
    String fileURL;
    String fileLocation;
    AOC1 aoc1;

    public AOC1P2(String session, String fileURL) {
        this.session = session;
        this.fileURL = fileURL;
        this.fileLocation = "src/main/resources/AOC1.txt";
        this.aoc1 = new AOC1(this.session, this.fileURL);
    }

    public List<String> convertNumbers() throws Exception {
        Map<String, Integer> NumberToInt = new HashMap<>();
        NumberToInt.put("one", 1);
        NumberToInt.put("two", 2);
        NumberToInt.put("three", 3);
        NumberToInt.put("four", 4);
        NumberToInt.put("five", 5);
        NumberToInt.put("six", 6);
        NumberToInt.put("seven", 7);
        NumberToInt.put("eight", 8);
        NumberToInt.put("nine", 9);

        StoreFileContent storeFileContent = new StoreFileContent(this.fileURL, this.session, this.fileLocation);
        storeFileContent.store();
        List<String> convertedList = new ArrayList<>();
        Scanner scanner = new Scanner(storeFileContent.file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                for (String key : NumberToInt.keySet()) {
                    if (line.startsWith(key, i)) {
                        // Replace the substring starting from position i with the corresponding value
                        String replacement = NumberToInt.get(key).toString();
                        line = line.substring(0, i) + replacement + line.substring(i + key.length());
                        break;  // Break the inner loop since we've found and replaced the key
                    }
                }
            }
            convertedList.add(line);

        }
        return convertedList;
    }

    public List<Integer> findFirstAndLastDigit() throws Exception {
        List<String> convertedList = convertNumbers();
        List<Integer> ListOfFirstAndLastDigit = new ArrayList<>();
        for (int i = 0; i < convertedList.size(); i++) {
            String[] lineArray = convertedList.get(i).split("");
            String firstDigit = "";
            String lastDigit = "";
            for (int j = 0; j < convertedList.get(i).length(); j++) {
                if (lineArray[j].matches("[0-9]")) {
                    if (firstDigit.equals("")) {
                        firstDigit = lineArray[j];
                    }
                    lastDigit = lineArray[j];
                }
            }
            ListOfFirstAndLastDigit.add(Integer.parseInt(firstDigit) * 10 + Integer.parseInt(lastDigit));
        }
        return ListOfFirstAndLastDigit;
    }

    public Integer sum() throws Exception {
        List<Integer> convertedList = findFirstAndLastDigit();
        int sum = 0;
        for (int i = 0; i < convertedList.size(); i++) {
            sum += convertedList.get(i);
        }
        return sum;
    }
}
