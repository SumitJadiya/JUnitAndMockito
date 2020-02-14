package com.in28minutes.junit.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SpyTest {

	@Test
	public void test() {
		// The mockito spy lets you check whether a method calls other methods.
		List arrayListMock = spy(ArrayList.class);
		assertEquals(0, arrayListMock.size());
		stub(arrayListMock.size()).toReturn(5);
		arrayListMock.add("Dummy");
		verify(arrayListMock).add("Dummy");
		assertEquals(5, arrayListMock.size());
	}
}
