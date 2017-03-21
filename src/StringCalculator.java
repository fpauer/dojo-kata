import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fernando
 *
 *
 *
String Calculator

The following is a TDD Kata- an exercise in coding, refactoring and test-first, 
that you should apply daily for at least 15 minutes (I do 30).

Before you start: 
Try not to read ahead.
Do one task at a time. The trick is to learn to work incrementally.
Make sure you only test for correct inputs. there is no need to test for invalid 
inputs for this kata

String Calculator

1. Create a simple String calculator with a method int Add(string numbers)
    1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty
string it will return 0) for example “” or “1” or “1,2”
    2. Start with the simplest test case of an empty string and move to 1 and two numbers
    3. Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
    4. Remember to refactor after each passing test
2. Allow the Add method to handle an unknown amount of numbers
3. Allow the Add method to handle new lines between numbers (instead of commas).
    1. the following input is ok:  “1\n2,3”  (will equal 6)
    2. the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
4. Support different delimiters
    1. to change a delimiter, the beginning of the string will contain a separate line that looks like this:   “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
    2. the first line is optional. all existing scenarios should still be supported
5. Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message

-------------------------------------------------------------------------------
stop here if you are a beginner. Continue if you can finish the steps so far in less than 30 minutes.
-------------------------------------------------------------------------------

6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
7. Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
8. Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
9. make sure you can also handle multiple delimiters with length longer than one char

 */
public class StringCalculator {

    public class NegativeNotAllowesException extends RuntimeException {
        public NegativeNotAllowesException(String message) { super(message); }
    }

    private String numbers = "";
    private List<String> delimiters;
    private String delimiterPrefix = "//";

    public StringCalculator(String numbers) {
        this.delimiters = new ArrayList<>();
        this.delimiters.add("\\n");
        this.numbers = numbers.trim();
        if (addDelimiters()) {
            removePrefix();
        }
    }

    private boolean addDelimiters() {
        String[] strs = this.numbers.split("[\n]");
        String delimiter = "";

        if (strs.length > 0 && strs[0].indexOf(delimiterPrefix) == 0) {
            delimiter = strs[0].replaceFirst(delimiterPrefix,"");
            if (delimiter.indexOf('[') == 0 && (delimiter.lastIndexOf(']') == delimiter.length()-1)) {
                String multipleDelimiter = "]"+delimiter+"[";
                String[] delimiters = multipleDelimiter.split("\\]\\[");
                for(String delimet: delimiters) {
                    if (!delimet.isEmpty()) {
                        this.delimiters.add(normalizeDelimiter(delimet));
                    }
                }
            } else {
                this.delimiters.add(normalizeDelimiter(delimiter));
            }
            return true;
        }

        return false;
    }

    private void removePrefix() {
        if (this.numbers.indexOf(delimiterPrefix)==0) {
            this.numbers = this.numbers.substring(this.numbers.indexOf("\n")+1);
        }
    }

    private String normalizeDelimiter(String delimiter){
        String newDelimiter = "";
        String escape = "\\";
        for (int i=0; i<delimiter.length(); i=i+1) {
            newDelimiter += escape + delimiter.charAt(i);
        }
        return newDelimiter;
    }

    private boolean isValid(int number) {
        if (number<0) {
            throw new NegativeNotAllowesException("Negatives not allowed");
        } else if (number>=1000) {
            return false;
        }
        return true;
    }

    private String[] extractNumbers() {
        String[] strs = new String[0];
        if (this.numbers.length()>0){
            this.applyDemiliters();
            strs = this.numbers.split("[,]");
        }
        return strs;
    }

    private void applyDemiliters() {
        for (String delimiter: this.delimiters) {
            this.numbers = this.numbers.replaceAll("("+delimiter+")+",",");
        }
    }

    public int Add() {
        String[] strs = extractNumbers();
        int sum = 0;

        for(int i=strs.length-1; i>=0; i = i-1) {
            int number = Integer.parseInt(strs[i]);
            if (isValid(number)) {
                sum += number;
            }
        }
        return sum;
    }

}