package com.paulgrandjean.tests;

import com.paulgrandjean.dao.Customer;
import com.paulgrandjean.dao.CustomerRequestBuilder;
import com.paulgrandjean.testbase.AbstractServiceTest;
import com.paulgrandjean.services.ServiceHandler;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public class AbstractCustomersTest extends AbstractServiceTest {

    public static String getBaseUrl() {
        return AbstractServiceTest.getBaseUrl() + "CUSTOMER/";
    };

    protected void addCustomer(Customer customer, String requestBody) throws IOException {
        serviceResponse = serviceHandler.postRequest(getBaseUrl(), requestBody);
        assertEquals("Create new record failed", ServiceHandler.STATUS_CREATED, serviceResponse.getStatusCode());
    }

    protected void deleteCustomer(Customer customer) throws IOException {
        serviceResponse = serviceHandler.deleteRequest(customer.getUrl());
        assertEquals("Delete record failed", ServiceHandler.STATUS_OK, serviceResponse.getStatusCode());
    }

    protected void changeValue(Customer customer, String paramString) throws IOException {
        serviceResponse = serviceHandler.postRequest(customer.getUrl(), paramString);
        assertEquals("POST failed.", ServiceHandler.STATUS_OK, serviceResponse.getStatusCode());
    }

    protected void verifyCustomer(Customer customer) throws IOException {
        serviceResponse = serviceHandler.getRequest(customer.getUrl());
        assertEquals("GET request failed.", ServiceHandler.STATUS_OK, serviceResponse.getStatusCode());
        Customer actualCustomer = new Customer(serviceResponse.getReader());
        assertEquals("Customer ID not found.", customer.getId(), actualCustomer.getId());
        assertEquals("First Name not found.", customer.getFirstName(), actualCustomer.getFirstName());
        assertEquals("Last Name not found.", customer.getLastName(), actualCustomer.getLastName());
        assertEquals("Street not found.", customer.getStreet(), actualCustomer.getStreet());
        assertEquals("City not found.", customer.getCity(), actualCustomer.getCity());
    }

    protected void verifyCustomerNotFound(Customer customer) throws IOException {
        serviceResponse = serviceHandler.getRequest(customer.getUrl());
        assertEquals("Expected not found but item exists.", ServiceHandler.STATUS_NOT_FOUND, serviceResponse.getStatusCode());
    }
}
