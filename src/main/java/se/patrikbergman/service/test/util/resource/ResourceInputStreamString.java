package se.patrikbergman.service.test.util.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class ResourceInputStreamString {
	private static final String ENCODING = "UTF-8";
	private final String string;

	public ResourceInputStreamString(final ResourceInputStream resourceInputStream) throws IOException {
		Preconditions.checkNotNull(resourceInputStream);
		this.string = IOUtils.toString(resourceInputStream, ENCODING);
	}

	@Override
	public String toString() {
		return string;
	}
}
