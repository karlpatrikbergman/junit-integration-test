package se.patrikbergman.service.test.fixture.resource.rest.request;

import org.junit.ClassRule;
import org.junit.Test;
import se.patrikbergman.service.test.fixture.rule.TestResourcesRule;
import se.patrikbergman.service.test.fixture.rule.annotation.InjectTestResource;
import se.patrikbergman.service.test.util.JsonString;

import static org.junit.Assert.assertNotNull;

public class RestRequestInjectionTest {

	@InjectTestResource(getFactory = RestRequestFactory.class, getMethod = "createLoginRequest")
	public static LoginRequest loginRequest;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE =
			new TestResourcesRule(RestRequestInjectionTest.class);

	@Test
	public void createLoginRequest() {
		assertNotNull(loginRequest);
		System.out.println(new JsonString(loginRequest));

	}
}
