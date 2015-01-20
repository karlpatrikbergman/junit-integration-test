package se.patrikbergman.service.test.fixture.environment.util;

import se.patrikbergman.service.test.fixture.environment.Environment;

/**
 * To use this class you need to use a Maven profile and Maven filtering together with a file called "config.properties"
 * that must be on the class path when class is loaded.
 *
 * If no Maven profile is used the value 'dev' will be used.
 */
public final class EnvironmentUtil {
	private static final String className = EnvironmentUtil.class.getSimpleName();
	private static final String resourceOnClasspath = "config.properties";
	private static Environment environment;

	static {
		try {
			System.out.println(String.format("%s: Reading environment from properties file (on classpath) '%s'", className, resourceOnClasspath));
			environment = new ResourceEnvironment(resourceOnClasspath).getEnvironment();
			System.out.println(String.format("%s: Set environment to '%s':", className, environment.getName()));
		} catch (RuntimeException e) {
			System.err.println(String.format("%s: static init block: Failed to discover environment using Maven " +
					"profile (resource filtering) and properties file config.properties. %s", className, e.getMessage()));
		}
	}

	public static Environment getEnvironmentFromClasspath() {
		return environment;
	}
}
