package se.patrikbergman.service.test.fixture.resource.customer;

import se.patrikbergman.service.test.fixture.domain.DatabaseDomain;
import se.patrikbergman.service.test.fixture.resource.datasource.DataSourceFactory;
import se.patrikbergman.service.test.fixture.resource.user.UserConfigurationFactory;

import javax.sql.DataSource;

public class CustomerInfoFactory {

	private final DataSource accountDataSource;
	private final String accountNumber;

	private CustomerInfoFactory() {
		accountDataSource = DataSourceFactory.getInstance().createDataSource(DatabaseDomain.ACCOUNT);
		accountNumber = UserConfigurationFactory.getInstance().createUserConfiguration().getAccountNumber();
	}

	private static class LazyHolder {
		private static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();
	}

	public static CustomerInfoFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	public CustomerInfo createCustomerInfo() {
		return new CustomerInfoDAO(accountNumber, accountDataSource).fetchCustomerInfo();
	}

	/**
	 * Some service that fetches customer info for a user in current environment
	 */
	private class CustomerInfoDAO {
		private final String accountNumber;
		private final DataSource dataSource;

		CustomerInfoDAO(final String accountNumber, final DataSource dataSource) {
			this.accountNumber = accountNumber;
			this.dataSource = dataSource;
		}

		CustomerInfo fetchCustomerInfo() {
			//Use data source and account number to fetch customer info
			return new CustomerInfo("Patrik", "Bergman", "patrik.bergman", "some-secret-password");
		}
	}
}
