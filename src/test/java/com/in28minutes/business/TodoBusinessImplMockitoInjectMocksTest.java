package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

	@Mock
	TodoService serviceMock;

	@InjectMocks
	TodoBusinessImpl businessImpl;

	@Captor
	ArgumentCaptor<String> argumentCaptor;

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		when(serviceMock.retrieveTodos("Dummy"))
				.thenReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_withEmptyList() {
		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

		given(serviceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		List<String> filteredTodos = businessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		given(serviceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		businessImpl.deleteTodosNotRelatedToSpring("Dummy");

		verify(serviceMock, times(1)).deleteTodo("Learn JPA");
		verify(serviceMock, atLeast(1)).deleteTodo("Learn JPA");
		verify(serviceMock, never()).deleteTodo("Learn Spring");
		verify(serviceMock, never()).deleteTodo("Learn Spring Boot");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

		given(serviceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot"));

		businessImpl.deleteTodosNotRelatedToSpring("Dummy");
		then(serviceMock).should().deleteTodo("Learn JPA");
		then(serviceMock).should().deleteTodo(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(), is("Learn JPA"));

		then(serviceMock).should().deleteTodo(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(2));
	}
}
