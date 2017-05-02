package kata04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fernando pauer on 3/22/17.

 Kata04: Data Munging

 Martin Fowler gave me a hard time for Kata02, complaining that it was yet another single-function, academic exercise.
 Which, or course, it was. So this week let’s mix things up a bit.

 Here’s an exercise in three parts to do with real world data. Try hard not to read ahead—do each part in turn.
 */
class FootballDataTest {

    String rootPath = System.getProperty("user.dir");
    String appPath = "/src/kata04/";
    File file;
    FootballData munging;
    String result;

    /*
     Part Two: Soccer League Table
     The file football.dat contains the results from the English Premier League for 2001/2. The columns labeled ‘F’
     and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals
     against opponents, and had 36 goals scored against them). Write a program to print the name of the team with
     the smallest difference in ‘for’ and ‘against’ goals.
    */
    @Test
    @DisplayName("Soccer Data")
    void testSoccerData() {
        Throwable exception = assertThrows(DataMunging.InvalidFileException.class, () -> {
            new FootballData("file.dat");
        });
        assertEquals("Please provide a valid file path.", exception.getMessage());
    }

    @Nested
    class TestSoccerDataFile {

        @BeforeEach
        void setUp() {
            file = new File(rootPath.concat(appPath.concat("football.dat")));
        }

        @Test
        @DisplayName("should load file football.dat")
        void loadSoccerFile() {
            assertTrue(file.exists());
        }

        @Test
        @DisplayName("should file football.dat not be empty")
        void emptySoccerFile() {
            assertTrue(file.length()>0);
        }
    }


    @Nested
    class TestSoccerData {

        TestSoccerData() {
            munging = new FootballData("football.dat");
            munging.map();
            result = munging.getResult();
        }

        @Test
        @DisplayName("should getResult not be empty")
        void dataNotEmptyTest() {
            assertNotNull(result);
            assertFalse(result.isEmpty());
        }

        @Test
        @DisplayName("should have the team name with smallest diff between F and A columns")
        void data1stColumnTest() {
            assertEquals("Aston_Villa", result);
        }
    }
}