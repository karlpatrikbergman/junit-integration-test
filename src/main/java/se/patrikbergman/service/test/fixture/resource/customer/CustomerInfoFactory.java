package se.patrikbergman.service.test.fixture.resource.customer;

import se.patrikbergman.service.test.fixture.environment.Environment;
import se.patrikbergman.service.test.fixture.environment.util.EnvironmentUtil;
import se.patrikbergman.service.test.util.resource.ResourceProperties;

import java.io.IOException;
import java.util.Properties;

public class CustomerInfoFactory {

	private final Environment environment;

	private CustomerInfoFactory() {
		environment = EnvironmentUtil.getInstance().getEnvironmentFromClasspath();
	}

	private static class LazyHolder {
		private static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();
	}

	public static CustomerInfoFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	/** In a real world example we would use DataSourceFactory and fetch user information from
	 *  a database in current test-environment (dev/test/qa)
	 * @return
	 */
	public CustomerInfo createCustomerInfo() {
		try {
			final String resourceOnClasspath = String.format("%s/customerinfo.properties", environment.getName());
			final Properties properties = new ResourceProperties(resourceOnClasspath);
			return new CustomerInfo.Builder()
					.firstName(properties.getProperty("firstname"))
					.lastName(properties.getProperty("lastname"))
					.username(properties.getProperty("username"))
					.password(properties.getProperty("password"))
					.phone(properties.getProperty("phone"))
					.build();
		} catch (IOException e) {
			throw new RuntimeException("Failed to create customer info. " + e.getMessage());
		}
	}
}
