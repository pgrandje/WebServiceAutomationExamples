package com.paulgrandjean.tests;

import com.paulgrandjean.dao.Customer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class AllCustomersParameterizedTest extends AbstractCustomersTest {

    @Parameters(name = "Customer/{index}/: ({1}, {2}, {3}, {4})")
    public static List counterData() {
        return Arrays.asList(new Object[][]{
                // Note: Customer IDs may not always be consecutive.
                {0, "Laura", "Steel", "429 Seventh Av.", "Dallas"},
                {1, "Susanne", "King", "366 - 20th Ave.", "Akron"},
                {2, "Anne", "Miller", "20 Upland Pl.", "Akron"},
                {3, "Michael", "Clancy", "542 Upland Pl.", "San Francisco"},
                {4, "Sylvia", "Ringer", "365 College Av.", "Dallas"},
                {5, "Laura", "Miller", "294 Seventh Av.", "Paris"},
                {6, "Laura", "White", "506 Upland Pl.", "Palo Alto"},
                {7, "James", "Peterson", "231 Upland Pl.", "San Francisco"},
                {8, "Andrew", "Miller", "288 - 20th Ave.", "Seattle"},
                {9, "James", "Schneider", "277 Seventh Av.", "Berne"},
                {10, "Sue", "Fuller", "135 Upland Pl.", "Dallas"},
                {11, "Julia", "White", "412 Upland Pl.", "Chicago"},
                {12, "George", "Ott", "381 Upland Pl.", "Palo Alto"},
                {13, "Laura", "Ringer", "38 College Av.", "New York"},
                {14, "Bill", "Karsen", "53 College Av.", "Oslo"},
                {15, "Bill", "Clancy", "319 Upland Pl.", "Seattle"},
                {16, "John", "Fuller", "195 Seventh Av.", "New York"},
                {17, "Laura", "Ott", "443 Seventh Av.", "Lyon"},
                {18, "Sylvia", "Fuller", "158 - 20th Ave.", "Paris"},
                {19, "Susanne", "Heiniger", "86 - 20th Ave.", "Dallas"}
        });
    }

    @Parameter
    public int idParameterized;
    @Parameter(value = 1)
    public String firstNameParameterized;
    @Parameter(value = 2)
    public String lastNameParameterized;
    @Parameter(value = 3)
    public String addressParameterized;
    @Parameter(value = 4)
    public String cityParameterized;

    Customer expectedCustomer;


    // *** Tests ***

    @Test
    public void testAllCustomers() throws IOException {
        expectedCustomer = new Customer(idParameterized,
                                        firstNameParameterized,
                                        lastNameParameterized,
                                        addressParameterized,
                                        cityParameterized
                                       );
        verifyCustomer(expectedCustomer);
    }
}
