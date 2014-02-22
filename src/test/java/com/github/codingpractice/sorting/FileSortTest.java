package com.github.codingpractice.sorting;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Patrick Kranz
 */
public class FileSortTest {
    @Test
    public void shouldSort() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt"));
        Random random = new Random();
        for (int i = 0; i<10000; i++) {
            writer.write(Long.toString(random.nextLong()));
            writer.newLine();
        }
        writer.flush();
        writer.close();
        FileSort.sort("numbers.txt");
    }
}
