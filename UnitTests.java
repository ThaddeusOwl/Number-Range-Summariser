package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class UnitTests {
    private final NumberRangeSummarizer summarizer;

    public UnitTests(NumberRangeSummarizer summarizer) {
        this.summarizer = summarizer;
    }

    public void runTests() {
        testCollect("1,3,6,7,8,12,13,14,15,21,22,23,24,31", Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));

        testSummarizeCollection(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31), "1, 3, 6-8, 12-15, 21-24, 31");

        System.out.println("All tests passed!");
    }

    private void testCollect(String input, Collection<Integer> expected) {
        Collection<Integer> result = summarizer.collect(input);
        if (!result.equals(expected)) {
            throw new AssertionError("Test failed for input: " + input + ". Expected: " + expected + ", but got: " + result);
        }
    }

    private void testSummarizeCollection(Collection<Integer> input, String expected) {
        String result = summarizer.summarizeCollection(input);
        if (!result.equals(expected)) {
            throw new AssertionError("Test failed for input: " + input + ". Expected: " + expected + ", but got: " + result);
        }
    }
}
