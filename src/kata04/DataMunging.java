package kata04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by fernandopauer on 3/22/17.


 Kata04: Data Munging

 Martin Fowler gave me a hard time for Kata02, complaining that it was yet another single-function, academic exercise.
 Which, or course, it was. So this week let’s mix things up a bit.

 Here’s an exercise in three parts to do with real world data. Try hard not to read ahead—do each part in turn.

 Part One: Weather Data
 In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file, then write a
 program to output the day number (column one) with the smallest temperature spread (the maximum temperature is
 the second column, the minimum the third column).

 Part Two: Soccer League Table
 The file football.dat contains the results from the English Premier League for 2001/2. The columns labeled ‘F’
 and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals
 against opponents, and had 36 goals scored against them). Write a program to print the name of the team with
 the smallest difference in ‘for’ and ‘against’ goals.

 Part Three: DRY Fusion
 Take the two programs written previously and factor out as much common code as possible, leaving you with two smaller
 programs and some kind of shared functionality.

 Kata Questions
 To what extent did the design decisions you made when writing the original programs make it easier or harder to factor
 out common code?

 Was the way you wrote the second program influenced by writing the first?

 Is factoring out as much common code as possible always a good thing? Did the readability of the programs suffer
 because of this requirement? How about the maintainability?
 */

public class DataMunging {

    public class InvalidFileException extends RuntimeException {
        public InvalidFileException(String message) { super(message); }
        public InvalidFileException(String message, Exception e) { super(message, e); }
    }

    private String rootPath = System.getProperty("user.dir");
    private String appPath = "/src/kata04/";
    private String filePath;
    private List<Float[]> result;

    public DataMunging (String filePath) {
        this.filePath = rootPath.concat(appPath.concat(filePath));
        if (!new File(this.filePath).exists()) {
            throw new InvalidFileException("Please provide a valid file path.");
        }
    }

    public void map() {
        result = new ArrayList<>(31);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                Float[] row = new Float[3];
                int column = 0;

                String[] cells = line.split(" ");
                for (String cell: cells) {
                    if (column<3) {
                        cell = cell.trim();
                        if (!cell.isEmpty() && isNumeric(cell)) {
                            row[column++] = Float.valueOf(cell);
                        }
                    }
                }

                if (column>0) {
                    System.out.println(Arrays.toString(row));
                    result.add(row);
                }
            }

        } catch (IOException e) {
            throw new InvalidFileException("", e);
        }
    }

    public List<Float[]> getResult() {
        return result;
    }

    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}
