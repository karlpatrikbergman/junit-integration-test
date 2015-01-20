package se.patrikbergman.service.test.fixture.resource.user;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserConfiguration {

	private final String userName;
	private final String password;
	private final String accountNumber;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	private UserConfiguration(Builder builder) {
		userName = builder.userName;
		password = builder.password;
		accountNumber = builder.accountNumber;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static final class Builder {
		private String userName;
		private String password;
		private String accountNumber;

		public Builder() {
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder accountNumber(String atgAccountNumber) {
			this.accountNumber = atgAccountNumber;
			return this;
		}

		public UserConfiguration build() {
			return new UserConfiguration(this);
		}
	}
}
