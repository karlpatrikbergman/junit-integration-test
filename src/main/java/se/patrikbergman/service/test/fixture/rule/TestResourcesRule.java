package se.patrikbergman.service.test.fixture.rule;

import com.google.common.base.Preconditions;
import org.junit.rules.ExternalResource;
import se.patrikbergman.service.test.fixture.rule.annotation.InjectTestResource;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestResourcesRule extends ExternalResource {
	public final Class target;

	public TestResourcesRule(Class target) {
		Preconditions.checkNotNull(target, "Test class cannot be null");
		this.target = target;
	}

	@Override
	public void before() throws IllegalAccessException, IOException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		for (Field field : target.getFields()) {
			if (field.isAnnotationPresent(InjectTestResource.class)) {
				final InjectTestResource injectTestResource = field.getAnnotation(InjectTestResource.class);
				final Class factoryClass = injectTestResource.getFactory();
				final Constructor constructor = factoryClass.getDeclaredConstructor();
				constructor.setAccessible(true);
				final Object factoryInstance = factoryClass.newInstance();
				final String methodName = injectTestResource.getMethod();
				final Method method = factoryClass.getMethod(methodName);
				method.setAccessible(true);
				final Object value = method.invoke(factoryInstance);
				field.set(target, value);
			}
		}
	}
}