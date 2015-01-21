package se.patrikbergman.service.test.fixture.resource.customer;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerInfo {
	private final String firstName;
	private final String lastName;
	private final String username;
	private final String password;
	private final String phone;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	private CustomerInfo(Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		username = builder.username;
		password = builder.password;
		phone = builder.phone;
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
		private String firstName;
		private String lastName;
		private String username;
		private String password;
		private String phone;

		public Builder() {
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public CustomerInfo build() {
			return new CustomerInfo(this);
		}
	}
}
