package kata04;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernando pauer on 3/22/17.

 Kata04: Data Munging

 Martin Fowler gave me a hard time for Kata02, complaining that it was yet another single-function, academic exercise.
 Which, or course, it was. So this week let’s mix things up a bit.

 Here’s an exercise in three parts to do with real world data. Try hard not to read ahead—do each part in turn.
 */
class DataMungingTest {

    String rootPath = System.getProperty("user.dir");
    String appPath = "/src/kata04/";
    File file;
    DataMunging munging;
    float[] result;

    /*
        Part One: Weather Data
        In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file,
        then write a program to output the day number (column one) with the smallest temperature spread (the maximum
        temperature is the second column, the minimum the third column).
    */
    @Test
    @DisplayName("Weather Data")
    void testWeatherData() {
        Throwable exception = assertThrows(DataMunging.InvalidFileException.class, () -> {
            new DataMunging("file.dat");
        });
        assertEquals("Please provide a valid file path.", exception.getMessage());
    }

    @Nested
    class TestWeatherDataFile {

        @BeforeEach
        void setUp() {
            file = new File(rootPath.concat(appPath.concat("weather.dat")));
        }

        @Test
        @DisplayName("should load file weather.dat")
        void loadWeatherFile() {
            assertTrue(file.exists());
        }

        @Test
        @DisplayName("should file weather.dat not be empty")
        void emptyWeatherFile() {
            assertTrue(file.length()>0);
            // assertThrows(EmptyStackException.class, () -> stack.peek());
        }
    }


    @Nested
    class TestWeatherData {

        TestWeatherData() {
            munging = new DataMunging("weather.dat");
            munging.map();
            result = munging.getResult();
        }

        @Test
        @DisplayName("should getData not be empty")
        void dataNotEmptyTest() {
            assertNotNull(result);
            assertTrue(result.length == 3);
        }

        @Test
        @DisplayName("should have the day number in the first column")
        void data1stColumnTest() {
            assertTrue(result[0] >= 1.0 && result[0] <= 31.0);
        }

        @Test
        @DisplayName("should have maximum temperature column as second and bigger then the third")
        void dataColumnTests() {
            assertTrue(result[1] > result[2]);
        }

        @Test
        @DisplayName("should output the smallest temperature spread")
        void smallestTemperatureTest() {
            assertEquals(14.0, result[0]);
            assertEquals(61.0, result[1]);
            assertEquals(59.0, result[2]);
        }
    }
}