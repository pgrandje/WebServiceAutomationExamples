package com.paulgrandjean.utils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public class DebugUtils {

    public static void printResponse(BufferedReader reader) throws IOException {
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
