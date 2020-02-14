package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Captor
	ArgumentCaptor<String> argumentCaptor;

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));

		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(6)).thenReturn(150);

		int result = systemUnderTest.methodCallingAStaticMethod();
		assertEquals(150, result);
		
		// check if UtilityClass.staticMethod(6) was called
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
		
		
	}
}
