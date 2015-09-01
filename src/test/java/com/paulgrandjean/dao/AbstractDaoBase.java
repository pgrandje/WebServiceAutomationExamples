package com.paulgrandjean.dao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public abstract class AbstractDaoBase {


    public static String getValueFromNextReaderLine(BufferedReader reader, String valueNameTag) throws IOException {
        String currentLine = reader.readLine();

        String substring = currentLine.substring(
                currentLine.indexOf("<" + valueNameTag +">") + valueNameTag.length() + 2,
                currentLine.indexOf("</" + valueNameTag +">")
        );

        return substring;
    }
}
