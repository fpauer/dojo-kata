package kata04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by fernandopauer on 4/13/17.

 Kata04: Data Munging

 Martin Fowler gave me a hard time for Kata02, complaining that it was yet another single-function, academic exercise.
 Which, or course, it was. So this week let’s mix things up a bit.

 Here’s an exercise in three parts to do with real world data. Try hard not to read ahead—do each part in turn.

 Part One: Weather Data
 In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file, then write a
 program to output the day number (column one) with the smallest temperature spread (the maximum temperature is
 the second column, the minimum the third column).
 */

public class WeatherData extends DataMunging {

    private float[] result;

    public WeatherData(String filePath) {
        super(filePath);
    }

    public void clearResult() {
        result = new float[]{0, Float.MAX_VALUE, Float.MIN_VALUE};
    }

    public void reduce(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            float[] row = new float[3];
            int column = 0;

            String[] cells = line.split(" ");
            for (String cell: cells) {
                if (column<3) {
                    cell = cell.trim();
                    if (!cell.isEmpty()) {
                        cell = cell.replaceAll("[*]", "");
                        if (isNumeric(cell)) {
                            row[column++] = Float.valueOf(cell);
                        } else if (column == 0) {
                            break;
                        }
                    }
                }
            }

            if (column>0) {
                float spreadRow = row[1] - row[2];
                float spreadResult = result[1] - result[2];
                if (spreadRow < spreadResult) {
                    result = row;
                }
            }
        }
    }

    public float[] getResult() {
        return result;
    }

}
