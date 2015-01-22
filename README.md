# junit-integration-test
An example of how one could dynamically set configuration for integration tests depending on Maven profile.
(dev, test, qa and stage)

Included is creation of:
- DataSources for injection in EJB:s.
- Configuration för remote REST-service. Tests with for example REST-assured
- Input test data that is dependent on which test-environment that the integration test is performed.

Example of usage of how to set a 

public class DataSourceInjectionTest {

	@InjectTestResource(getFactory = DataSourceFactory.class, getMethod = DataSourceFactoryMethod.ACCOUNT)
	public static DataSourceImpl accountDataSource;

	@ClassRule
	public static final TestResourcesRule TEST_RESOURCES_RULE = new TestResourcesRule(DataSourceInjectionTest.class);

	@Test
	public void createAccountDataSource() {
	  //A real test could include instatiation of EJB that uses data source
	  //MyService myService = new MyService(accountDataSource);
	  //assertNotNull(myService.getSomeDataFromDataSource())
	  
		assertNotNull(accountDataSource);
		System.out.println(accountDataSource);

	}
}


