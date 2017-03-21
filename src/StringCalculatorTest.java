import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author fernando
 */
public class StringCalculatorTest {

    StringCalculator exceptionInstance = new StringCalculator("");

    /**
     * Test of main method, of class StringCalculator.
     */
    /*
    Create a simple String calculator with a method int Add(string numbers)
    1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty
      string it will return 0) for example “” or “1” or “1,2”
    2. Start with the simplest test case of an empty string and move to 1 and two numbers
    3. Remember to solve things as simply as possible so that you force yourself
       to write tests you did not think about it.
    4. Remember to refactor after each passing test
    */
    @Test
    public void testAdd1() {
        String empty = "";
        String singleNumber = "1";
        String numbers = "1,2";

        assertEquals(0, new StringCalculator(empty).Add() );
        assertEquals(1, new StringCalculator(singleNumber).Add() );
        assertEquals(3, new StringCalculator(numbers).Add() );
    }

    /*
    2. Allow the Add method to handle an unknown amount of number
    */
    @Test
    public void testAdd2() {
        String numbers1to3 = "1,2,3";
        String numbers1to5 = "1,2,3,4,5";
        String numbers1to11 = "1,2,3,4,5,6,7,8,9,10,11";
        assertEquals(6, new StringCalculator(numbers1to3).Add());
        assertEquals(15, new StringCalculator(numbers1to5).Add());
        assertEquals(66, new StringCalculator(numbers1to11).Add());
    }

    /*
    3. Allow the Add method to handle new lines between numbers (instead of commas).
        1. the following input is ok:  “1\n2,3”  (will equal 6)
        2. the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
    */
    @Test
    public void testAdd3() {
        String numbersWithNewLines = "1\n3";
        String numbersWithNewLinesWrong = "1\n";
        assertEquals(4, new StringCalculator(numbersWithNewLines).Add());
        assertEquals(1, new StringCalculator(numbersWithNewLinesWrong).Add());
    }

    /*
    4. Support different delimiters
        1. to change a delimiter, the beginning of the string will contain a separate line
        that looks like this:   “//[delimiter]\n[numbers…]”
        for example “//;\n1;2” should return 3 where the default delimiter is ‘;’ .
        2. the first line is optional. all existing scenarios should still be supported
    */
    @Test
    public void testAdd4() {
        String numbersWithNewLinesAndWithouDelimiters = "1\n3";
        String numbersWithNewLinesAndWithDelimiters = "//;\n1;2";
        assertEquals(4, new StringCalculator(numbersWithNewLinesAndWithouDelimiters).Add());
        assertEquals(3, new StringCalculator(numbersWithNewLinesAndWithDelimiters).Add());
    }

    /*
    5. Calling Add with a negative number will throw an exception “negatives not allowed” -
       and the negative that was passed.if there are multiple negatives, show all of them in
       the exception message
    */
    @Test
    public void testAdd5_firstNegativeNumber() {
        String firstNegativeNumber = "1\n-3";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(firstNegativeNumber).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    @Test
    public void testAdd5_lastNegativeNumber() {
        String lastNegativeNumber = "1,-3";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(lastNegativeNumber).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    @Test
    public void testAdd5_MiddleNegativeNumber() {
        String middleNegativeNumber = "1,-3,5";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(middleNegativeNumber).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    @Test
    public void testAdd5_MultipleNegativeNumbers1() {
        String multipleNegativeNumbers1 = "1,-3,-5";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(multipleNegativeNumbers1).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    @Test
    public void testAdd5_MultipleNegativeNumbers2() {
        String multipleNegativeNumbers2 = "-1,-3,5";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(multipleNegativeNumbers2).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    @Test
    public void testAdd5_AllNegativeNumbers() {
        String allNegativeNumbers = "-1\n-3,-5";

        Throwable exception = assertThrows(StringCalculator.NegativeNotAllowesException.class, () -> {
            new StringCalculator(allNegativeNumbers).Add();
        });
        assertEquals("Negatives not allowed", exception.getMessage());
    }

    /*
    6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
    */
    @Test
    public void testAdd6() {
        String numbersWith1000 = "1000\n3";
        String numbersLessThen1000 = "//;\n1;999";
        String multipleNegativeNumbers2 = "1,1000,5";
        assertEquals(3, new StringCalculator(numbersWith1000).Add());
        assertEquals(1000, new StringCalculator(numbersLessThen1000).Add());
        assertEquals(6, new StringCalculator(multipleNegativeNumbers2).Add());
    }

    /*
    7. Delimiters can be of any length with the following format:  “//[delimiter]\n”
       for example: “//[***]\n1***2***3” should return 6
    */
    @Test
    public void testAdd7() {
        String numbersWithNewDelimiters = "//[***]\n1***2***3";
        //assertEquals(6, new StringCalculator(numbersWithNewDelimiters).Add());
    }

    /*
    8. Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
     */
    @Test
    public void testAdd8() {
        String numbersWithMultipleDelimiters1 = "//[*][%]\n1*2%3";
        String numbersWithMultipleDelimiters2 = "//[*][%]\n1*2%3,4\n5";
        assertEquals(6, new StringCalculator(numbersWithMultipleDelimiters1).Add());
        assertEquals(15, new StringCalculator(numbersWithMultipleDelimiters2).Add());
    }

    /*
    9. make sure you can also handle multiple delimiters with length longer than one char
     */
    @Test
    public void testAdd9() {
        String numbersWithLongerDelimiters1 = "//[**][%%]\n1**2%%3";
        String numbersWithLongerDelimiters2 = "//[%*%][*%*]\n1%*%2*%*3,4\n5";
        assertEquals(6, new StringCalculator(numbersWithLongerDelimiters1).Add());
        assertEquals(15, new StringCalculator(numbersWithLongerDelimiters2).Add());
    }

    //*/
}