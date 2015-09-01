package com.paulgrandjean.dao;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public class CustomerRequestBuilder {

    static final String ID = "ID";
    static final String FIRST_NAME = "FIRSTNAME";
    static final String LAST_NAME = "LASTNAME";
    static final String STREET = "STREET";
    static final String CITY = "CITY";

    public static String getIdParam(String id) {
        return "<" + ID + ">" + id + "</" + ID + ">";
    }

    public static String getFirstNameParam(String firstName) {
        return "<" + FIRST_NAME + ">" + firstName + "</" + FIRST_NAME + ">";
    }

    public static String getLastNameParam(String lastName) {
        return "<" + LAST_NAME + ">" + lastName + "</" + LAST_NAME + ">";
    }

    public static String getStreetParam(String street) {
        return "<" + STREET + ">" + street + "</" + STREET + ">";
    }

    public static String getCityParam(String city) {
        return "<" + CITY + ">" + city + "</" + CITY + ">";
    }

    public static String getRequestBody(Customer customer) {

        return
            "<resource>" +
                    getIdParam(new Integer(customer.getId()).toString()) +
                    getFirstNameParam(customer.getFirstName()) +
                    getLastNameParam(customer.getLastName()) +
                    getStreetParam(customer.getStreet()) +
                    getCityParam(customer.getCity()) +
            "</resource>";
    }
}
