package se.patrikbergman.service.test.fixture.resource.rest.service;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RestServiceConfiguration {
	private final String host;
	private final int port;
	private final String basePath;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getBasePath() {
		return basePath;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private RestServiceConfiguration(Builder builder) {
		host = builder.host;
		port = builder.port;
		basePath = builder.basePath;
	}


	public static final class Builder {
		private String host;
		private int port;
		private String basePath;

		public Builder() {
		}

		public Builder host(String host) {
			this.host = host;
			return this;
		}

		public Builder port(int port) {
			this.port = port;
			return this;
		}

		public Builder basePath(String basePath) {
			this.basePath = basePath;
			return this;
		}

		public RestServiceConfiguration build() {
			return new RestServiceConfiguration(this);
		}
	}
}
