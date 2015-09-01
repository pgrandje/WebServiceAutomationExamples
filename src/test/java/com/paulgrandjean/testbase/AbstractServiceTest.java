package com.paulgrandjean.testbase;

import org.junit.Before;
import com.paulgrandjean.services.ServiceHandler;
import com.paulgrandjean.services.ServiceResponse;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/31/15
 */
public abstract class AbstractServiceTest {

    private static final String baseUrl = "http://localhost:8080/sqlrest/";
    protected ServiceHandler serviceHandler;
    protected ServiceResponse serviceResponse;

    public static String getBaseUrl() {
        return baseUrl;
    };

    public AbstractServiceTest() {
        serviceHandler = new ServiceHandler();
    }

    // TODO: Evaluate if there's some common setup steps I can offload to the base class.
    @Before
    public void setUp() {

    }
}
