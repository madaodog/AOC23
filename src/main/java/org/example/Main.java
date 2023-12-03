package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        /**
        AOC1 aoc1 = new AOC1("**", "https://adventofcode.com/2023/day/1/input");
        try {
            System.out.println(aoc1.sum());
        } catch (Exception e) {
            e.printStackTrace();
        }

         }

        AOC1P2 aoc1P2 = new AOC1P2("**", "https://adventofcode.com/2023/day/1/input");
        try {
            System.out.println(aoc1P2.sum());
        } catch (Exception e) {
            e.printStackTrace();
        }
         **/

        /**AOC2 aoc2 = new AOC2("*", "https://adventofcode.com/2023/day/2/input");
        try {
            List<Integer> indices = aoc2.getGamesLowerThan(12,13,14);
            System.out.println(Arrays.toString(indices.toArray()));
            System.out.println(aoc2.sum(aoc2.getGamesLowerThan(12,13,14)));
            System.out.println(aoc2.findMinimum());
        } catch (Exception e) {
            e.printStackTrace();

        }
         */

        /**Pattern pattern = Pattern.compile("(\\d+) (\\w+[a-z])");
        Matcher matcher = pattern.matcher("123test 456 test 44test");
        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }
         */

    }
}