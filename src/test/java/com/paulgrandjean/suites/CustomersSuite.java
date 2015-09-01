package com.paulgrandjean.suites;

import com.paulgrandjean.tests.AllCustomersParameterizedTest;
import com.paulgrandjean.tests.CustomersTest;
import com.paulgrandjean.tests.RemoteWebServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TODO: Add javadoc here.
 *
 * @author Paul Grandjean
 * @version 1.0alpha
 * @since 8/27/15
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CustomersTest.class, AllCustomersParameterizedTest.class, RemoteWebServiceTest.class})
public class CustomersSuite {
}
