package se.patrikbergman.service.test.fixture.resource.user;


import se.patrikbergman.service.test.fixture.environment.Environment;
import se.patrikbergman.service.test.fixture.environment.util.EnvironmentUtil;
import se.patrikbergman.service.test.util.resource.ResourceProperties;

import java.io.IOException;
import java.util.Properties;

public class UserConfigurationFactory {

	private final Environment environment;

	public UserConfigurationFactory() {
		environment = EnvironmentUtil.getEnvironmentFromClasspath();
	}

	private static class LazyHolder {
		private static final UserConfigurationFactory INSTANCE = new UserConfigurationFactory();
	}

	public static UserConfigurationFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	public UserConfiguration createUserConfiguration() {
		try {
			final String resourceOnClasspath = String.format("%s/user.properties", environment.getName());
			final Properties properties = new ResourceProperties(resourceOnClasspath);
			return new UserConfiguration.Builder()
					.userName(properties.getProperty("user.name"))
					.password(properties.getProperty("password"))
					.accountNumber(properties.getProperty("account.number"))
					.build();
		} catch (IOException e) {
			throw new RuntimeException("Failed to create user configuration. " + e.getMessage());
		}
	}
}
