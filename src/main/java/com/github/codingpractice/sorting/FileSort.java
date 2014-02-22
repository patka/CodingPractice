package com.github.codingpractice.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.io.File.createTempFile;

/**
 * Sorts a big file of Strings
 *
 * @author Patrick Kranz
 */
public class FileSort {
    private static final int CHUNK_SIZE_IN_LINES = 1000;

    private FileSort() {
        // prevent instance creation
    }

    public static void sort(String fileName) throws IOException {
        List<File> files = new ArrayList<>();
        try {
            files = splitFile(fileName);
            File target = File.createTempFile("sorting", ".tmp");
            // multiple file handles at once or real merging?
            // what is faster considering also the disk io?
            mergeFiles(files, target);
            target.renameTo(new File(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            removeTempFile(files);
        }

    }

    private static void removeTempFile(List<File> files) {
        for (File file : files) {
            file.delete();
        }
    }

    private static void mergeFiles(List<File> files, File target) {
        try {
            try (FileWriter writer = new FileWriter(target)) {
                List<BufferedReader> readers = openFileReader(files);
                String[] currentLines = new String[readers.size()];
                fillCurrentLines(currentLines, readers);

                while (!isDone(currentLines)) {
                    int index = findLowestValue(currentLines);
                    writer.write(currentLines[index]);
                    writer.write(System.lineSeparator());
                    fillCurrentLines(currentLines, readers, index);
                }
                closeReaders(readers);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<BufferedReader> openFileReader(List<File> files) throws FileNotFoundException {
        List<BufferedReader> readers = new ArrayList<>();
        for(File file : files) {
            readers.add(new BufferedReader(new FileReader(file)));
        }
        return readers;
    }

    private static void closeReaders(List<BufferedReader> readers) throws IOException {
        for (BufferedReader reader : readers) {
            reader.close();
        }
    }

    private static boolean isDone(String[] lines) {
        for(int i = 0; i<lines.length; i++) {
            if (lines[i] != null) return false;
        }
        return true;
    }

    private static void fillCurrentLines(String[] currentLines, List<BufferedReader> readers, int index) throws IOException {
        if (!readers.get(index).ready()) {
            currentLines[index] = null;
            return;
        }
        currentLines[index] = readers.get(index).readLine();
    }

    private static int findLowestValue(String[] currentLines) {
        int lowest = 0;
        for (int i = 0; i<currentLines.length; i++) {
            if (currentLines[i] != null) {
                lowest = i;
                break;
            }
        }
        for (int i = 0; i<currentLines.length; i++) {
            if (currentLines[i] != null && currentLines[lowest].compareTo(currentLines[i]) > 0) {
                lowest = i;
            }
        }
        return lowest;
    }

    private static void fillCurrentLines(String[] currentLines, List<BufferedReader> readers) throws IOException {
        for(int i = 0; i<currentLines.length; i++) {
            BufferedReader reader = readers.get(i);
            if (reader.ready()) {
                currentLines[i] = reader.readLine();
            }
        }
    }

    private static List<File> splitFile(String fileName) throws IOException {
        List<File> fileNames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready()) {
            List<String> chunk = new ArrayList<>();
            for (int i = 0; i<CHUNK_SIZE_IN_LINES && reader.ready(); i++) {
                chunk.add(reader.readLine());
            }
            Collections.sort(chunk);

            File tmpFile = createTempFile("sorting", "tmp");
            System.out.println("Creating tmp file " + tmpFile.getAbsolutePath());
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
            for(String line : chunk) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
            fileNames.add(tmpFile);
        }

        return fileNames;
    }
}
