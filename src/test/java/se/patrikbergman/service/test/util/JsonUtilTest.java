package se.patrikbergman.service.test.util;

import org.junit.Test;
import se.patrikbergman.service.test.fixture.resource.user.UserConfiguration;

import java.io.IOException;

public class JsonUtilTest {

	@Test
	public void objectToJsonString() throws IOException {
		UserConfiguration userConfiguration = new UserConfiguration.Builder()
				.userName("John Doe")
				.accountNumber("123456789")
				.password("secret")
				.build();
		System.out.println(new JsonString(userConfiguration));
	}
}
