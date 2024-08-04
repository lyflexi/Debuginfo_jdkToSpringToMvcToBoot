package org.lyflexi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }


    public static void main(String[] args) {
        char[] input = new char[]{'a', 'b', 'c', 'c', 'b', 'd', 'c'};
        char[] answer = solution(input);
        for (Character c : answer) {
            System.out.println(c);
        }
    }

    private static char[] solution(char[] array) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        char[] answer = new char[map.size()];
        int i = 0;


        List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().sorted((Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) -> {
            return o1.getValue() - o2.getValue();
        }).collect(Collectors.toList());

        for (Map.Entry<Character, Integer> entry : collect) {
            answer[i] = entry.getKey();
            i++;
        }
        return answer;
    }
}
