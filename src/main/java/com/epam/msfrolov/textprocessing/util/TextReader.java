package com.epam.msfrolov.textprocessing.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TextReader {
    public static Random random = new Random();

    public static String read(String path) {
        InputStream inputStream = TextReader.class.getClassLoader().getResourceAsStream(path);
        return new Scanner(inputStream).useDelimiter("\\A").next();
    }

    public static String getRandomLine(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(TextReader.class.getClassLoader().getResourceAsStream(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new FileReadException(e);
        }
        return lines.get(random.nextInt(lines.size()));
    }
}
