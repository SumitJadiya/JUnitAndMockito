package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

@SuppressWarnings("rawtypes")
public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	public void letsMockListSize_returnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("STJ");
		assertEquals("STJ", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void letsMockListGet_testArgumentMatcher() {
		List listMock = mock(List.class);

		// Argument Matcher
		when(listMock.get(anyInt())).thenReturn("Sumit");
		assertEquals("Sumit", listMock.get(4343));
	}

	@Test(expected = RuntimeException.class)
	public void letsMockListGet_testRuntimeException() {
		List listMock = mock(List.class);

		// Throwing Exceptions
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Some Exception"));
		listMock.get(0);
	}

}
