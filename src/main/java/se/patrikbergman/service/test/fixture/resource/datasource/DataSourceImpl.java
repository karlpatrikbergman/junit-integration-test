package se.patrikbergman.service.test.fixture.resource.datasource;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.sql.SQLException;

public class DataSourceImpl extends OracleDataSource {

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(" Driver type: " + getDriverType() + NEW_LINE);
		result.append(" Service name: " + getServiceName() + NEW_LINE);
		result.append(" Server name: " + getServerName() + NEW_LINE );
		result.append(" Port number: " + getPortNumber() + NEW_LINE);
		result.append(" User: " + getUser() + NEW_LINE);
		result.append("}");

		return result.toString();
	}

	private DataSourceImpl(Builder builder) throws SQLException {
		setDriverType(builder.driverType);
		setServiceName(builder.serviceName);
		setServerName(builder.serverName);
		setPortNumber(builder.portNumber);
		setUser(builder.user);
		setPassword(builder.password);
	}

	public static final class Builder {
		private String driverType;
		private String serviceName;
		private String serverName;
		private int portNumber;
		private String user;
		private String password;

		public Builder setDriverType(String driverType) {
			this.driverType = driverType;
			return this;
		}

		public Builder setServiceName(String serviceName) {
			this.serviceName = serviceName;
			return this;
		}

		public Builder setServerName(String serverName) {
			this.serverName = serverName;
			return this;
		}

		public Builder setPortNumber(int portNumber) {
			this.portNumber = portNumber;
			return this;
		}

		public Builder setUser(String user) {
			this.user = user;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public DataSourceImpl build() throws SQLException {
			return new DataSourceImpl(this);
		}
	}
}