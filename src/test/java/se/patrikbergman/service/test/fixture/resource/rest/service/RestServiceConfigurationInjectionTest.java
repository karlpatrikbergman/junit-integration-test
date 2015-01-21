package se.patrikbergman.service.test.fixture.resource.rest.service;

import org.junit.ClassRule;
import org.junit.Test;
import se.patrikbergman.service.test.fixture.rule.TestResourcesRule;
import se.patrikbergman.service.test.fixture.rule.annotation.InjectTestResource;
import se.patrikbergman.service.test.util.JsonString;

import static org.junit.Assert.assertNotNull;

public class RestServiceConfigurationInjectionTest {

	@InjectTestResource(getFactory = RestServiceConfigurationFactory.class, getMethod = "createRestServiceConfiguration")
	public static RestServiceConfiguration restServiceConfiguration;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE =
			new TestResourcesRule(RestServiceConfigurationInjectionTest.class);

	@Test
	public void createRestServiceConfiguration() {
		assertNotNull(restServiceConfiguration);
		System.out.println(new JsonString(restServiceConfiguration));

	}
}
