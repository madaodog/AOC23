package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOC2 {
    String session;
    String fileURL;
    String fileLocation;

    public AOC2(String session, String fileURL) {
        this.session = session;
        this.fileURL = fileURL;
        this.fileLocation = "src/main/resources/AOC2.txt";
    }

    public List<Map<String, List<Integer>>> findOccurences() throws Exception {
        StoreFileContent storeFileContent = new StoreFileContent(this.fileURL, this.session, this.fileLocation);
        storeFileContent.store();
        Scanner scanner = new Scanner(storeFileContent.file);
        List indexedOccurences = new ArrayList();
        Pattern pattern = Pattern.compile("(\\d+) (\\w+[a-z])");

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            for(String pull : line.split("Game")) {
                Map<String, List<Integer>> occurences = new HashMap<>();
                Matcher matcher = pattern.matcher(pull);
                while(matcher.find()) {
                    if(occurences.containsKey(matcher.group(2))) {
                        occurences.get(matcher.group(2)).add(Integer.parseInt(matcher.group(1)));
                       // System.out.println(matcher.group(2) + ":" + occurences.get(matcher.group(2)).get(0));
                    } else {
                        occurences.put(matcher.group(2), new ArrayList<>());
                        occurences.get(matcher.group(2)).add(Integer.parseInt(matcher.group(1)));
                        //System.out.println(matcher.group(2) + ":" + occurences.get(matcher.group(2)).get(0));
                    }
                }
                if(occurences.size() != 0)
                    indexedOccurences.add(occurences);
            }
        }
        return indexedOccurences;

    }

    public List<Integer> getGamesLowerThan(int redNumber, int greenNumber, int blueNumber) throws Exception {
        List<Integer> indices = new ArrayList<>();
        int index = 0;
        for(Map<String, List<Integer>> occurence: findOccurences()) {
            index++;
            if(occurence.get("red").stream().allMatch(element -> element <= redNumber) &&
            occurence.get("blue").stream().allMatch(element -> element <= blueNumber) &&
            occurence.get("green").stream().allMatch(element -> element <= greenNumber))
                indices.add(index);
        }
        return indices;
    }

    public int sum(List<Integer> indices) {
        int sum = 0;
        for(Integer index: indices) {
            sum += index;
        }
        return sum;
    }

    public int findMinimum() throws Exception {
        List<Integer> findMin = new ArrayList<>();
        for(Map<String, List<Integer>> occurence: findOccurences()) {
            int maxRed = Collections.max(occurence.get("red"));
            int maxBlue = Collections.max(occurence.get("blue"));
            int maxGreen = Collections.max(occurence.get("green"));
            int power = maxRed * maxBlue * maxGreen;
            findMin.add(power);
        }
        return sum(findMin);
    }



}
