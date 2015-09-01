package com.paulgrandjean.tests;

import com.paulgrandjean.dao.Customer;
import com.paulgrandjean.testbase.AbstractServiceTest;
import com.paulgrandjean.utils.DebugUtils;
import org.junit.Before;
import org.junit.Test;
import com.paulgrandjean.services.ServiceResponse;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/27/15
 */
public class RemoteWebServiceTest extends AbstractServiceTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testAllAvailableResources() throws IOException {
        ServiceResponse serviceResponse = serviceHandler.getRequest("http://www.thomas-bayer.com/sqlrest/CUSTOMER/1/");
        DebugUtils.printResponse(serviceResponse.getReader());
    }

    @Test
    public void testCustomer1() throws IOException {
        Customer expectedCustomer = new Customer(1, "Susanne", "King", "366 - 20th Ave.", "Olten");

        ServiceResponse serviceResponse = serviceHandler.getRequest("http://www.thomas-bayer.com/sqlrest/CUSTOMER/1/");
        Customer actualCustomer = new Customer(serviceResponse.getReader());

        assertEquals("Customer ID not found.", expectedCustomer.getId(), actualCustomer.getId());
        assertEquals("First Name not found.", expectedCustomer.getFirstName(), actualCustomer.getFirstName());
    }
}
