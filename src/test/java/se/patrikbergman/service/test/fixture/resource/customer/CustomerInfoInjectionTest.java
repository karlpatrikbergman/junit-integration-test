package se.patrikbergman.service.test.fixture.resource.customer;

import org.junit.ClassRule;
import org.junit.Test;
import se.patrikbergman.service.test.fixture.rule.TestResourcesRule;
import se.patrikbergman.service.test.fixture.rule.annotation.InjectTestResource;

import static org.junit.Assert.assertNotNull;

public class CustomerInfoInjectionTest {

	@InjectTestResource(getFactory = CustomerInfoFactory.class, getMethod = "createCustomerInfo")
	public static CustomerInfo customerInfo;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE = new TestResourcesRule(CustomerInfoInjectionTest.class);

	@Test
	public void createCustomerInfo() {
		assertNotNull(customerInfo);
		System.out.println(customerInfo);

	}
}
