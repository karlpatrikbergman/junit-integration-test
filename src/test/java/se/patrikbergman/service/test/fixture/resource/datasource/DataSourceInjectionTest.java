package se.patrikbergman.service.test.fixture.resource.datasource;

import org.junit.ClassRule;
import org.junit.Test;
import se.patrikbergman.service.test.fixture.rule.TestResourcesRule;
import se.patrikbergman.service.test.fixture.rule.annotation.InjectTestResource;

import static org.junit.Assert.assertNotNull;

public class DataSourceInjectionTest {

	@InjectTestResource(getFactory = DataSourceFactory.class, getMethod = DataSourceFactoryMethod.ACCOUNT)
	public static DataSourceImpl accountDataSource;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE = new TestResourcesRule(DataSourceInjectionTest.class);

	@Test
	public void createAccountDataSource() {
		assertNotNull(accountDataSource);
		System.out.println(accountDataSource);

	}
}
