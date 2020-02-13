package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

// Dummy implementation of TodoService
public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {

		return Arrays.asList("Learn Spring", "Learn JPA", "Learn Spring Boot");
	}

	public void deleteTodo(String todo) {
	}
}
