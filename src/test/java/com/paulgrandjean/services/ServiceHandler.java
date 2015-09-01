package com.paulgrandjean.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public class ServiceHandler {

    public static final int STATUS_OK = 200;
    public static final int STATUS_CREATED = 201;
    public static final int STATUS_NOT_FOUND = 404;
    public static final int STATUS_SERVER_ERROR = 500;


    public ServiceHandler() {
    }

    public ServiceResponse getRequest(String url) throws IOException {
        // Note: New client must be recreated for each request.
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = client.execute(request);
        ServiceResponse response = new ServiceResponse(httpResponse.getStatusLine().getStatusCode());
        response.setReader(new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent())));
        return response;
    }

    public ServiceResponse postRequest(String url, String messageBody) throws IOException {
        // Note: New client must be recreated for each request.
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity input = new StringEntity(messageBody);
        post.setEntity(input);
        HttpResponse httpResponse = client.execute(post);
        int statusCode = httpResponse.getStatusLine().getStatusCode();

        return new ServiceResponse(statusCode);
    }

    public ServiceResponse deleteRequest(String url) throws IOException {
        // Note: New client must be recreated for each request.
        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete request = new HttpDelete(url);
        HttpResponse httpResponse = client.execute(request);
        return new ServiceResponse(httpResponse.getStatusLine().getStatusCode());
    }
}
