package se.patrikbergman.service.test.fixture.resource.rest.request;

import se.patrikbergman.service.test.fixture.resource.customer.CustomerInfo;
import se.patrikbergman.service.test.fixture.resource.customer.CustomerInfoFactory;


public class RestRequestFactory {
	private final CustomerInfo customerInfo;

	private RestRequestFactory() {
		customerInfo = CustomerInfoFactory.getInstance().createCustomerInfo();
	}

	private static class LazyHolder {
		private static final RestRequestFactory INSTANCE = new RestRequestFactory();
	}

	public static RestRequestFactory getInstance() {
		return LazyHolder.INSTANCE;
	}

	//In clear text for simplicity
	public LoginRequest createLoginRequest() {
		return new LoginRequest(customerInfo.getUsername(), customerInfo.getPassword());
	}
}
