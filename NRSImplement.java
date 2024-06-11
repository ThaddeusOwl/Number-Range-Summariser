package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NRSImplement implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new ArrayList<>();

        String[] parts = input.split(",");
        for (String part : parts) {
            
            numbers.add(Integer.parseInt(part.trim()));
        }
        
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        List<Integer> sortedList = new ArrayList<>(input);
        String result = "";
        int start = sortedList.get(0);
        int end = start;

        for (int i = 1; i < sortedList.size(); i++) {
            int current = sortedList.get(i);
            if (current == end + 1) {
                end = current;
            } else {
                result = appendRange(result, start, end);
                start = current;
                end = current;
            }
        }
        result = appendRange(result, start, end); 
        return result;
    }

    private String appendRange(String result, int start, int end) {
        if (!result.isEmpty()) {
            result += ", ";
        }
        if (start == end) {
            result += start;
        } else {
            result += start + "-" + end;
        }
        return result;
    }

       public static void main(String[] args) {
        NRSImplement summarizer = new NRSImplement();
        
        UnitTests unitTests = new UnitTests(summarizer);
        unitTests.runTests();
    }

    

}