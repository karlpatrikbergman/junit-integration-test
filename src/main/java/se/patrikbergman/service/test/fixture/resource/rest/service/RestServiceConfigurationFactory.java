package se.patrikbergman.service.test.fixture.resource.rest.service;

import se.patrikbergman.service.test.fixture.environment.Environment;
import se.patrikbergman.service.test.fixture.environment.util.EnvironmentUtil;
import se.patrikbergman.service.test.util.resource.ResourceProperties;

import java.io.IOException;
import java.util.Properties;

public class RestServiceConfigurationFactory {

	private final Environment environment;

	private RestServiceConfigurationFactory() {
		environment = EnvironmentUtil.getEnvironmentFromClasspath();
	}

	private static class LazyHolder {
		private static final RestServiceConfigurationFactory INSTANCE = new RestServiceConfigurationFactory();
	}

	public static RestServiceConfigurationFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	public RestServiceConfiguration createRestServiceConfiguration() {
		try {
			final String resourceOnClasspath = String.format("%s/rest-service.properties", environment.getName());
			final Properties properties = new ResourceProperties(resourceOnClasspath);
			return new RestServiceConfiguration.Builder()
					.host(properties.getProperty("rest.service.host"))
					.port(Integer.parseInt(properties.getProperty("rest.service.port")))
					.basePath(properties.getProperty("rest.service.base.path"))
					.build();
		} catch (IOException e) {
			throw new RuntimeException("Failed to rest service configuration. " + e.getMessage());
		}
	}
}
