package se.patrikbergman.service.test.util.resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

public class ResourcesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private final String resourceOnClassPath = "dev/user.properties";

	@Test
	public void getInputStreamFromResourceOnClasspath() throws IOException {
		final InputStream inputStream = new ResourceInputStream(resourceOnClassPath);
		assertNotNull(inputStream);
	}

	@Test
	public void getPropertiesFromResourceOnClasspath() throws IOException {
		final Properties properties = new ResourceProperties(resourceOnClassPath);
		assertNotNull(properties);
	}

	@Test
	public void getStringFromInputStream() throws IOException {
		final String string = new ResourceInputStreamString(
									new ResourceInputStream(resourceOnClassPath)
								).toString();
		assertNotNull(string);
	}

	@Test
	public void getStringFromInputStream2() throws IOException {
		final String string = new ResourceString(resourceOnClassPath).toString();
		assertNotNull(string);
	}

	@Test
	public void getNonExistingResource() throws IOException {
		thrown.expect(IOException.class);
		new ResourceInputStream("non-existing-path");
	}
}
