package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		// Mocking
		TodoService serviceMock = mock(TodoService.class);
		when(serviceMock.retrieveTodos("Dummy"))
				.thenReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		TodoBusinessImpl businessImpl = new TodoBusinessImpl(serviceMock);
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_withEmptyList() {
		// Mocking
		TodoService serviceMock = mock(TodoService.class);

		TodoBusinessImpl businessImpl = new TodoBusinessImpl(serviceMock);
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

		// Given
		TodoService serviceMock = mock(TodoService.class);
		given(serviceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		TodoBusinessImpl businessImpl = new TodoBusinessImpl(serviceMock);

		// When
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
		assertThat(filteredTodos.size(), is(2));
	}
}
