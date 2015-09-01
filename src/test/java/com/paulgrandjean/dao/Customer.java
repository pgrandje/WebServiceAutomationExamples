package com.paulgrandjean.dao;

import com.paulgrandjean.tests.AbstractCustomersTest;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/28/15
 */
public class Customer extends AbstractDaoBase {

    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;


    public Customer(int id, String firstName, String lastName, String street, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
    }

    public Customer (BufferedReader reader) throws IOException {

        // Ignore <?xml...> container but if newlines are missing the number of readLines will vary.
        String line = reader.readLine();
        while (line != null && !line.contains("<CUSTOMER")) {
            line = reader.readLine();;
        }

        if (line == null) {
            throw new RuntimeException("Customer record not found.");
        }
        this.id = Integer.parseInt(getValueFromNextReaderLine(reader, CustomerRequestBuilder.ID));
        this.firstName = getValueFromNextReaderLine(reader, CustomerRequestBuilder.FIRST_NAME);
        this.lastName = getValueFromNextReaderLine(reader, CustomerRequestBuilder.LAST_NAME);
        this.street = getValueFromNextReaderLine(reader, CustomerRequestBuilder.STREET);
        this.city = getValueFromNextReaderLine(reader, CustomerRequestBuilder.CITY);
    }

    public String getUrl() {
        return AbstractCustomersTest.getBaseUrl() + id + "/";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
