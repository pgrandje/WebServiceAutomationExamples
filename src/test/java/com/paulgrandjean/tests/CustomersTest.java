package com.paulgrandjean.tests;

import com.paulgrandjean.dao.Customer;
import com.paulgrandjean.dao.CustomerRequestBuilder;
import org.junit.Test;
import com.paulgrandjean.services.ServiceHandler;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Simple test class to demo testing web-services.
 * Tests a localhost installed version of Thomas Bayer's sqlRest web-service example.
 * For doc's see:
 * http://www.predic8.com/rest-demo.htm
 *  http://sqlrest.sourceforge.net/5-minutes-guide.htm
 *
 * The base URL is
 *  http://localhost:8080/sqlrest/
 * And a few example URLs
 *  http://localhost:8080/sqlrest/CUSTOMER/
 *  http://localhost:8080/sqlrest/CUSTOMER/2/
 *  http://localhost:8080/sqlrest/CUSTOMER/8/
 *
 * Use Firefox's Poster Add-On to manually inspect the web-services and verify GET, POST, DELETE operations
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/27/15
 */
public class CustomersTest extends AbstractCustomersTest {

    // TODO: Add logging

    @Test
    public void testGetCustomer() throws IOException {

        final int customerId = 1;
        Customer expectedCustomer = new Customer(customerId, "Susanne", "King", "366 - 20th Ave.", "Akron");
        verifyCustomer(expectedCustomer);
    }

    @Test
    public void testChangeCity() throws IOException {

        final String oldCity = "Akron";
        final String newcity = "Detroit";
        Customer customer = new Customer(2, "Anne", "Miller", "20 Upland Pl.", oldCity);

        // Verify the original record.
        verifyCustomer(customer);

        // Change the city
        customer.setCity("Detroit");
        changeValue(customer, CustomerRequestBuilder.getCityParam(newcity));

        // Verify the changed city
        verifyCustomer(customer);

        // Now change it back
        customer.setCity(oldCity);
        changeValue(customer, CustomerRequestBuilder.getCityParam(oldCity));

        // Verify the city is changed back.
        verifyCustomer(customer);
    }

    @Test
    public void testAddDeleteCustomer() throws IOException {

        // TODO: Get a random integer for ID to ensure test runs even if earlier errors caused delete to fail.
        Customer addedCustomer = new Customer(100, "Add", "Test", "111 First St.", "Phoenix");

        // Add new record and verify
        addCustomer(addedCustomer, CustomerRequestBuilder.getRequestBody(addedCustomer));
        verifyCustomer(addedCustomer);

        // Delete and verify not found.
        deleteCustomer(addedCustomer);
        verifyCustomerNotFound(addedCustomer);
    }
}
