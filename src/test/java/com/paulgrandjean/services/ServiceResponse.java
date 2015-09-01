package com.paulgrandjean.services;

import java.io.BufferedReader;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public class ServiceResponse {

    private int statusCode;
    private BufferedReader reader;

    public ServiceResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
