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
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethodTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Captor
	ArgumentCaptor<String> argumentCaptor;

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() throws Exception {
		when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));

		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		assertEquals(6, result);
	}
}
