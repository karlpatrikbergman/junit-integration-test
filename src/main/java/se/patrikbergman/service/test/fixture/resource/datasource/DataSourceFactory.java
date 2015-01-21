package se.patrikbergman.service.test.fixture.resource.datasource;

import se.patrikbergman.service.test.fixture.domain.DatabaseDomain;
import se.patrikbergman.service.test.fixture.environment.Environment;
import se.patrikbergman.service.test.fixture.environment.util.EnvironmentUtil;
import se.patrikbergman.service.test.util.resource.ResourceProperties;

import javax.sql.DataSource;
import java.util.Properties;

public final class DataSourceFactory {

	private final Environment environment;

	private DataSourceFactory() {
		environment = EnvironmentUtil.getEnvironmentFromClasspath();
	}

	private static class LazyHolder {
		private static final DataSourceFactory INSTANCE = new DataSourceFactory();
	}

	public static DataSourceFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	public DataSource createAccountDataSource() {
		return createDataSource(DatabaseDomain.ACCOUNT);
	}

	public DataSource createTransactionsDataSource() {
		return createDataSource(DatabaseDomain.TRANSACTIONS);
	}

	public DataSource createDataSource(final DatabaseDomain databaseDomain) {
		try {
			final String resourceOnClasspath = String.format("%s/%s-datasource.properties", environment.getName(),
					databaseDomain.getName());
			final Properties properties = new ResourceProperties(resourceOnClasspath);
			return new DataSourceImpl.Builder()
					.setDriverType(properties.getProperty("driver.type"))
					.setServerName(properties.getProperty("server.dns.name"))
					.setPortNumber(Integer.parseInt(properties.getProperty("server.port")))
					.setServiceName(properties.getProperty("service.name"))
					.setUser(properties.getProperty("user"))
					.setPassword(properties.getProperty("password"))
					.build();
		} catch (Exception e) {
			throw new RuntimeException("Failed to rest data source. " + e.getMessage());
		}
	}
}

